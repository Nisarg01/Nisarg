package com.foliobear.nisarg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;




/**
 * Created by Nisarg on 11/25/2016.
 */

public class Lite extends Activity implements View.OnClickListener {

    EditText url;
    WebView ourBrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        ourBrow = (WebView) findViewById(R.id.wvBrowser);

        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.getSettings().setLoadWithOverviewMode(true);
        ourBrow.getSettings().setUseWideViewPort(true);

        try {
            ourBrow.loadUrl("https://www.google.com");
        }
        catch (Exception e) {
        e.printStackTrace();
        }
            ourBrow.setWebViewClient(new ourClient());

        Button go = (Button) findViewById(R.id.bGo);
        Button back = (Button) findViewById(R.id.bGo);
        Button forward = (Button) findViewById(R.id.bGo);
        Button refresh = (Button) findViewById(R.id.bGo);
        Button clear = (Button) findViewById(R.id.bGo);
        url = (EditText) findViewById(R.id.etURL);

        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bGo:
                String theWebsite = url.getText().toString();
                ourBrow.loadUrl(theWebsite);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(), 0);

            break;

            case R.id.bBack:
                if (ourBrow.canGoBack())
                    ourBrow.goBack();
                break;

            case R.id.bForward:
                if (ourBrow.canGoForward())
                    ourBrow.goForward();
                break;

            case R.id.bRefresh:
                ourBrow.reload();
                break;

            case R.id.bHistory:
                ourBrow.clearHistory();
                break;
        }
    }
}
