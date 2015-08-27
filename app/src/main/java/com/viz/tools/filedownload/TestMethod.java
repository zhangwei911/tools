package com.viz.tools.filedownload;

public class TestMethod {
    public TestMethod() { ///xx/weblogic60b2_win.exe
        try {
            SiteInfoBean bean = new SiteInfoBean("http://localhost/Youku_Phone_youkuweb.apk",
                    "E:\\", "Youku_Phone_youkuweb.apk", 5);
            SiteFileFetch fileFetch = new SiteFileFetch(bean);
            fileFetch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestMethod();
    }
}