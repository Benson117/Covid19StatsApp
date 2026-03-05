package com.android.covid19stats.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.android.covid19stats.R;


public class LiveMapFragment extends Fragment {

    static WebView mWeb;
    private View mContentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_live_map, null);
        mWeb = mContentView.findViewById(R.id.webView);

        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        mWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWeb.getSettings().setBuiltInZoomControls(false);
        mWeb.loadUrl("https://www.bing.com/covid");
        mWeb.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mWeb.canGoBack()) {
                    mWeb.goBack();
                    return true;
                }
                return false;
            }
        });
        return mContentView;
    }
}