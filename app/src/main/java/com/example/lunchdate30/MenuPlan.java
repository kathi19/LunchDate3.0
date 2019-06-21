package com.example.lunchdate30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MenuPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_plan);

        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.loadUrl("https://www.stw-ma.de/speiseplan_mensaria_metropol.html");
    }
}
