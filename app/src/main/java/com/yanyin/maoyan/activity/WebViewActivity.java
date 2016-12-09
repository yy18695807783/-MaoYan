package com.yanyin.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanyin.maoyan.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebViewActivity extends Activity {

    @Bind(R.id.web_chacha)
    ImageView webChacha;
    @Bind(R.id.wb_content)
    WebView wbContent;
    @Bind(R.id.web_title)
    TextView webTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        //取出intent
        Intent intent = getIntent();
        String web = intent.getStringExtra("web");
        if (web != null) {
            setWebView(web);
        }

        String title = intent.getStringExtra("title");
        if(!TextUtils.isEmpty(title)){
            webTitle.setText(title);
        }

        initListener();

    }

    //点击监听
    private void initListener() {
        webChacha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); 
            }
        });
    }

    private void setWebView(String web) {
        if (web != null) {
            wbContent.loadUrl(web);
            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
            wbContent.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });

            //启用支持javascript
            WebSettings settings = wbContent.getSettings();
            settings.setJavaScriptEnabled(true);

            //优先使用缓存
            wbContent.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

    }

}




