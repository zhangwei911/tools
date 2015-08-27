package com.viz.tools.json;

import com.viz.tools.HtmlGet;
import com.viz.tools.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viz on 2014/11/13.
 */
public class Json {

    private static String connServerForResult(String strUrl) {
        // HttpGet对象
        HttpGet httpRequest = new HttpGet(strUrl);
        String strResult = "";
        try {
            // HttpClient对象
            HttpClient httpClient = new DefaultHttpClient();
            // 获得HttpResponse对象
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 取得返回的数据
                strResult = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (ClientProtocolException e) {
            Log.i("protocol error");
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("IO error");
            e.printStackTrace();
        }
        return strResult;
    }

    public static List<String> parse(String JSON, String[] objs) {
        List<String> stringList = new ArrayList<String>();
        try {
            JSONTokener jsonParser = new JSONTokener(JSON);
            // 此时还未读取任何json文本，直接读取就是一个JSONObject对象。
            // 如果此时的读取位置在"name" : 了，那么nextValue就是"yuanzhifei89"（String）
            JSONObject jsonObject = (JSONObject) jsonParser.nextValue();
            // 接下来的就是JSON对象的操作了
            for (String obj : objs) {
                stringList.add(jsonObject.getString(obj));
            }
            return stringList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> p(String JSON, String obj, String[] obj2s) throws JSONException {
        List<String> stringList = new ArrayList<String>();
        JSONObject dataJson = new JSONObject(JSON);
        JSONArray data = dataJson.getJSONArray(obj);
        JSONObject info = data.getJSONObject(0);
        for (String s : obj2s) {
            stringList.add(info.getString(s));
        }
        return stringList;
    }

    // 普通Json数据解析
    private static List<String> parseJson(String strResult, String obj, String[] objs) {
        List<String> stringList = new ArrayList<String>();
        try {
            JSONObject jsonObj = new JSONObject(strResult).getJSONObject(obj);
            for (String str : objs) {
                stringList.add(jsonObj.getString(str));
            }
            return stringList;
        } catch (Exception e) {
            System.out.println("Json parse error");
            e.printStackTrace();
        }
        return null;
    }

    //解析多个数据的Json
    private static List<List<String>> parseJsonMulti(String strResult, String array, String obj, String[] objs) {
        List<List<String>> stringLists = new ArrayList<List<String>>();
        List<String> stringList = new ArrayList<String>();
        try {
            JSONArray jsonObjs = new JSONObject(strResult).getJSONArray(array);
            for (int i = 0; i < jsonObjs.length(); i++) {
                JSONObject jsonObj = ((JSONObject) jsonObjs.opt(i))
                        .getJSONObject(obj);
                for (String str : objs) {
                    stringList.add(jsonObj.getString(str));
                }
                stringLists.add(stringList);
                stringList.clear();
            }
            return stringLists;
        } catch (Exception e) {
            System.out.println("Jsons parse error !");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        List<String> lists = Json.parseJson(HtmlGet.download("https://openapi.youku.com/v2/searches/show/by_keyword.json?keyword=使徒行者&client_id=860f605e6c5f7a64"), "shows", new String[]{"id","name","link","paly_link","poster","thumbnail","streamtypes","showcategory","description","area","completed","episode_count","episode_updated","hasvideotype","view_count","score","paid","published"});
        List<String> lists = Json.parse(HtmlGet.download("https://openapi.youku.com/v2/searches/show/by_keyword.json?keyword=" + URLEncoder.encode("使徒行者", "utf-8") + "&client_id=860f605e6c5f7a64"), new String[]{"id", "shows"});
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
