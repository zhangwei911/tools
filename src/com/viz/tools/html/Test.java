package com.viz.tools.html;

import java.util.List;

/**
 * Created by viz on 2014/11/6.
 */
public class Test {
    public static void main(String[] args) {
        HtmlGet htmlGet = new HtmlGet("http://www.flvcd.com/parse.php?kw=http://v.youku.com/v_show/id_XODA4MjU5NTQ0_ev_1.html&flag=one&format=normal");
        List<List<String>> lists = htmlGet.getLinksInfo("a[href]",null);
        List<String> href = lists.get(0);
        List<String> hrefabs = lists.get(1);
        List<String> text = lists.get(2);
        List<String> num = lists.get(3);
        String html=htmlGet.getHtml();
        for (String s : href) {
            System.out.println(s);
        }
        System.out.println("------------------");
        for (String s : hrefabs) {
            System.out.println(s);
        }
        System.out.println("@@@@@@@@@@@@@@@@");
        for (String s : text) {
            System.out.println(s);
        }
        System.out.println("````````````````````````");
        for (String s : num) {
            System.out.println(s);
        }
        HtmlGet htmlGet1 = new HtmlGet("http://v.youku.com/v_show/id_XODA4MjU5NTQ0_ev_1.html");
        System.out.println("``##############`");
        System.out.print(htmlGet1.getHtml());

    }
}
