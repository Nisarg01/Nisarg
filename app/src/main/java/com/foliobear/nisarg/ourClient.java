package com.foliobear.nisarg;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Nisarg on 11/26/2016.
 */

public class ourClient extends WebViewClient {

    @Override

    public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest request){

        Uri url = request.getUrl();
        v.loadUrl(String.valueOf(url));
        return true;
    }
}
