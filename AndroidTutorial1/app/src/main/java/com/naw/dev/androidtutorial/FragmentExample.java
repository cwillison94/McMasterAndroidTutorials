package com.naw.dev.androidtutorial;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.naw.dev.androidtutorial1.R;

public class FragmentExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        setUpFragment();
    }

    private void setUpFragment() {

        Fragment f1 = ExampleFragmentTop.newInstance();
        Fragment f2 = ExampleFragmentBottom.newInstance();
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.fragmentTop, f1)
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK).commit();

        frgManager.beginTransaction().replace(R.id.fragmentBottom, f2)
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK).commit();

    }
}
