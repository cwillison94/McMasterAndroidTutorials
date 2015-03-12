package com.naw.dev.androidtutorial;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.naw.dev.androidtutorial1.R;

public class ExampleFragmentTop extends Fragment {

    private WebView webView;

    public static ExampleFragmentTop newInstance() {
        ExampleFragmentTop fragment = new ExampleFragmentTop();
        return fragment;
    }

    public ExampleFragmentTop() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_example_fragment_top, container, false);
        webView = (WebView) view.findViewById(R.id.webView);

        webView.loadUrl("https://www.google.ca/?gws_rd=ssl");
        // Inflate the layout for this fragment
        return view;

    }
}
