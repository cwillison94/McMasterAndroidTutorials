package com.naw.dev.androidtutorial;



import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naw.dev.androidtutorial1.R;

public class ExampleFragmentBottom extends Fragment {

    public static ExampleFragmentBottom newInstance() {
        ExampleFragmentBottom fragment = new ExampleFragmentBottom();
        return fragment;
    }

    public ExampleFragmentBottom() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example_fragment_bottom, container, false);

    }
}
