package cz.sribagavathmission;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by macbook on 18/07/16.
 */
public class WebViewActivity extends AppCompatActivity {

    String Url = null;
    String type = null;
    String CurrentUrl = null;

    WebView webView;
    ProgressBar pbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);



        webView = (WebView) findViewById(R.id.webview);
        pbar    = (ProgressBar)findViewById(R.id.progressBar1);
        Url = getIntent().getStringExtra("url");

        if(getIntent().getStringExtra("type") != null)
        type = getIntent().getStringExtra("type");



        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebViewClient(new MyBrowser());

        if(type == null) {

            webView.loadUrl(Url);

        } else {

            webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + Url);
        }


    }

    private class MyBrowser extends WebViewClient {


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            CurrentUrl = url;
            Log.e("CurrentUrl",CurrentUrl);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            pbar.setVisibility(View.GONE);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }
}
