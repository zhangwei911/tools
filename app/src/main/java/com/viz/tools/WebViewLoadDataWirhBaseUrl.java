package com.viz.tools;

import android.webkit.WebView;

/**
 * Created by viz on 2014/11/13.
 */
public class WebViewLoadDataWirhBaseUrl {
    /**
     * Loads the given data into this WebView, using baseUrl as the base URL for
     * the content. The base URL is used both to resolve relative URLs and when
     * applying JavaScript's same origin policy. The historyUrl is used for the
     * history entry.
     * <p>
     * Note that content specified in this way can access local device files
     * (via 'file' scheme URLs) only if baseUrl specifies a scheme other than
     * 'http', 'https', 'ftp', 'ftps', 'about' or 'javascript'.
     * <p>
     * If the base URL uses the data scheme, this method is equivalent to
     * calling {@link #loadData(String,String,String) loadData()} and the
     * historyUrl is ignored, and the data will be treated as part of a data: URL.
     * If the base URL uses any other scheme, then the data will be loaded into
     * the WebView as a plain string (i.e. not part of a data URL) and any URL-encoded
     * entities in the string will not be decoded.
     *
     * @param baseUrl the URL to use as the page's base URL. If null defaults to
     *                'about:blank'.
     * @param data a String of data in the given encoding
     * @param mimeType the MIMEType of the data, e.g. 'text/html'. If null,
     *                 defaults to 'text/html'.
     * @param encoding the encoding of the data
     * @param historyUrl the URL to use as the history entry. If null defaults
     *                   to 'about:blank'. If non-null, this must be a valid URL.
     */
    public static void load(WebView webView, String baseUrl, String data,
                            String mimeType, String encoding, String historyUrl) {
        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    public static void loadDefault(WebView webView, String baseUrl, String data) {
        load(webView, baseUrl, data, "text/html", "UTF-8", null);
    }
}
