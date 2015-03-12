package com.naw.dev.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naw.dev.androidtutorial1.R;

public class WeatherActivity extends Activity implements View.OnClickListener {


    //global variable declarations for buttons
    private Button bSubmit;
    private EditText etLocation;
    private TextView tvWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //call method to set up widgets
        setUpWidgets();
    }

    /**
     * This method is called every time the view is clicked
     *
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSubmit:
                //create object to pull network data
                WeatherDataPull weatherPuller = new WeatherDataPull(tvWeather);
                weatherPuller.execute(etLocation.getText().toString().replace(" ", ""));
                break; //break out of case
        }
    }
    private void setUpWidgets() {
        bSubmit = (Button) findViewById(R.id.bSubmit);
        // attach onClickListener to button
        //NOTE: the class itself is the OnClickListener object
        bSubmit.setOnClickListener(this);
        etLocation = (EditText) findViewById(R.id.etLocation);
        tvWeather = (TextView) findViewById(R.id.tvWeather);
    }


}
