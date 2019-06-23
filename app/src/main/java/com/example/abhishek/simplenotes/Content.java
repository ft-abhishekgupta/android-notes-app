package com.example.abhishek.simplenotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.abhishek.R;

public class Content extends AppCompatActivity {

    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
        Intent i=getIntent();
        String s=i.getStringExtra("name");
        w= (WebView) findViewById(R.id.wv);
        WebSettings settings = w.getSettings();
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        int p=i.getIntExtra("pos",-1);
        setTitle(s);
        switch(p){
            case 0:w.loadUrl("file:///android_asset/topic1/topic1.html");break;
            case 1:w.loadUrl("file:///android_asset/topic2/topic2.html");break;
            case 2:w.loadUrl("file:///android_asset/topic3/topic3.html");break;
            case 3:w.loadUrl("file:///android_asset/topic4/topic4.html");break;
            case 4:w.loadUrl("file:///android_asset/topic5/topic5.html");break;
        }
    }
}
