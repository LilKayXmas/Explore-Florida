package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class ExploreWebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_web);

        webView = findViewById(R.id.webView);
        setupWebView();

        // Get the URL from the intent's extras
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("websiteUrl")) {
            String websiteUrl = intent.getStringExtra("websiteUrl");
            loadWebsite(websiteUrl);
        } else {
            // Default website URL if no extra is provided
            loadWebsite("https://google.com/");
        }
    }

    private void setupWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Ensure links open in the WebView, not in a browser
        webView.setWebViewClient(new WebViewClient());
    }

    private void loadWebsite(String websiteUrl) {
        // Load the specified website URL
        webView.loadUrl(websiteUrl);
    }

    // Handle the back button to navigate within the WebView
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}