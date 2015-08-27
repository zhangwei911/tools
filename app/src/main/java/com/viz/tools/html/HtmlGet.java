package com.viz.tools.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viz on 2014/11/6.
 */
public class HtmlGet {
    private Document doc;
    private String url;

    public HtmlGet(String url) {
        this.url = url;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document getDoc() {
        try {
            return Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHtml() {
        return getDoc().html();
    }

    /**
     * 通过link类型来获取元素数组
     *
     * @param type 类型，标签[属性]/[属性]，如a[href]，[src],link[src]
     * @return 元素数组
     */
    public Elements getLinks(String type) {
        return doc.select(type);
    }

    /**
     * 获取link信息
     *
     * @param type   类型，标签[属性]/[属性]，如a[href]，[src],link[src]
     * @param filter 过滤字符串
     * @return
     */
    public List<List<String>> getLinksInfo(String type, String filter) {
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> href = new ArrayList<String>();
        List<String> hrefabs = new ArrayList<String>();
        List<String> text = new ArrayList<String>();
        List<String> num = new ArrayList<String>();
        Elements links = getLinks(type);
        if (filter != null) {
            for (Element link : links) {
                if (link.attr("abs:href").contains(filter)) {
                    href.add(link.attr("href"));
                    hrefabs.add(link.attr("abs:href"));
                    text.add(trim(link.text(), 35));
                }
            }
        } else {
            for (Element link : links) {
                href.add(link.attr("href"));
                hrefabs.add(link.attr("abs:href"));
                text.add(trim(link.text(), 35));
            }
        }
        num.add(href.size() + "");
        lists.add(href);
        lists.add(hrefabs);
        lists.add(text);
        lists.add(num);
        return lists;
    }

    private static String print(String msg, Object... args) {
        return String.format(msg, args);
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width - 1);
        else
            return s;
    }
}
