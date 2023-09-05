package com.collectcent.gamepad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.adjust.sdk.LogLevel;
import com.adjust.sdk.webbridge.AdjustBridge;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

public class MainActivity extends AppCompatActivity {

    WebView webViewMain ;
    ProgressBar progressBarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webViewMain = findViewById(R.id.webViewMain);
        progressBarMain = findViewById(R.id.pgBarMain);
        webViewMain.loadUrl("https://www.gamesluv.com/");
        webViewMain.getSettings().setDomStorageEnabled(true);
        webViewMain.getSettings().setLoadsImagesAutomatically(true);
        webViewMain.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webViewMain.getSettings().setDomStorageEnabled(true);
        webViewMain.getSettings().setSaveFormData(true);
        webViewMain.getSettings().setAllowContentAccess(true);
        webViewMain.getSettings().setAllowFileAccess(true);
        webViewMain.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewMain.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewMain.getSettings().setSupportZoom(true);
        //6.1
        webViewMain.getSettings().setJavaScriptEnabled(true);
        webViewMain.setClickable(true);
        webViewMain.setWebChromeClient(new WebChromeClient());
        webViewMain.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBarMain.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBarMain.setVisibility(View.INVISIBLE);
            }

        });


        //Step 5
//        InstallReferrerClient referrerClient;
//
//        referrerClient = InstallReferrerClient.newBuilder(this).build();
//        referrerClient.startConnection(new InstallReferrerStateListener() {
//            @Override
//            public void onInstallReferrerSetupFinished(int responseCode) {
//                switch (responseCode) {
//                    case InstallReferrerClient.InstallReferrerResponse.OK:
//                        // Connection established.
//                        try {
//                            ReferrerDetails response = referrerClient.getInstallReferrer();
//                            String referrerUrl = response.getInstallReferrer();
//                            long referrerClickTime = response.getReferrerClickTimestampSeconds();
//                            long appInstallTime = response.getInstallBeginTimestampSeconds();
//                            boolean instantExperienceLaunched = response.getGooglePlayInstantParam();
//                            // Process the referrer details as needed.
//                        } catch (RemoteException e) {
//                            e.printStackTrace();
//                        }
//                        break;
//                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
//                        // API not available on the current Play Store app.
//                        break;
//                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
//                        // Connection couldn't be established.
//                        break;
//                }
//                referrerClient.endConnection();
//            }
//
//            @Override
//            public void onInstallReferrerServiceDisconnected() {
//                // Try to restart the connection on the next request to
//                // Google Play by calling the startConnection() method.
//            }
//        });

        InstallReferrerClient referrerClient;
        referrerClient = InstallReferrerClient.newBuilder(this).build();
        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {

                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        // Connection established.
                        ReferrerDetails response = null;
                        try {
                            response = referrerClient.getInstallReferrer();
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                        String referrerUrl = response.getInstallReferrer();
                        long referrerClickTime = response.getReferrerClickTimestampSeconds();
                        long appInstallTime = response.getInstallBeginTimestampSeconds();
                        boolean instantExperienceLaunched = response.getGooglePlayInstantParam();
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        // API not available on the current Play Store app.
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        // Connection couldn't be established.
                        break;
                }
                referrerClient.endConnection();
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {

            }
        });
        //6.2
        AdjustBridge.registerAndGetInstance(getApplication(),webViewMain);




    }

    @Override
    protected void onDestroy() {

        AdjustBridge.unregister();
        super.onDestroy();
    }

//        AdjustBridge.registerAndGetInstance(getApplication(), webViewMain);
//        try {
////            webViewMain.loadUrl("file:///android_asset/webViewMain.html");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        AdjustBridge.unregister();
//
//        super.onDestroy();

//

    @Override
    public void onBackPressed() {
        if (webViewMain.canGoBack())
        {
            webViewMain.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}