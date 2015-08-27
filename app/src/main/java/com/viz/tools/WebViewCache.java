package com.viz.tools;

import android.content.Context;
import android.webkit.WebSettings;

import java.io.File;

/**
 * Created by viz on 2014/10/28.
 */
public class WebViewCache {
    private WebSettings webSettings;
    private Context context;
    private String APP_CACAHE_DIRNAME = "/webcache";


    public WebViewCache(Context context, WebSettings webSettings) {
        this.context = context;
        this.webSettings = webSettings;
    }

    /**
     * 设置优先使用缓存
     */
    public void setCache() {
        Log.i("加载优先使用缓存");
        //设置优先级
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //设置 缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //缓存最多可以有8M
        webSettings.setAppCacheMaxSize(8 * 1024 * 1024);
        //自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        // 开启 DOM storage API 功能
        webSettings.setDomStorageEnabled(true);
        //开启 database storage API 功能
        webSettings.setDatabaseEnabled(true);
        String cacheDirPath = context.getFilesDir().getAbsolutePath() + APP_CACAHE_DIRNAME;
        Log.i("cacheDirPath=" + cacheDirPath);
        //设置数据库缓存路径
        webSettings.setDatabasePath(cacheDirPath);
        //设置  Application Caches 缓存目录
        webSettings.setAppCachePath(cacheDirPath);
        //开启 Application Caches 功能
        webSettings.setAppCacheEnabled(true);
    }


    /**
     * 清除WebView缓存
     */
    public void clearWebViewCache() {

        //清理Webview缓存数据库
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //WebView 缓存文件
        File appCacheDir = new File(context.getFilesDir().getAbsolutePath() + APP_CACAHE_DIRNAME);
        Log.i("appCacheDir path=" + appCacheDir.getAbsolutePath());

        File webviewCacheDir = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        Log.i("webviewCacheDir path=" + webviewCacheDir.getAbsolutePath());

        //删除webview 缓存目录
        if (webviewCacheDir.exists()) {
            deleteFile(webviewCacheDir);
        }
        //删除webview 缓存 缓存目录
        if (appCacheDir.exists()) {
            deleteFile(appCacheDir);
        }
    }

    /**
     * 递归删除 文件/文件夹
     *
     * @param file
     */
    public void deleteFile(File file) {

        Log.i("delete file path=" + file.getAbsolutePath());

        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        } else {
            Log.e("delete file no exists " + file.getAbsolutePath());
        }
    }
}
