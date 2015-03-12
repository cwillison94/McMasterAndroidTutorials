package com.naw.dev.androidtutorial;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fs on 2015-03-10.
 *
 * This class parses weather information in the JSON format from the open weather api
 */
public class WeatherParserJSON {

    private String weatherTxt;

    /**
     * Constructor
     *
     * @param weatherTxt The JSON weather data
     *
     * */
    public WeatherParserJSON(String weatherTxt) {
        this.weatherTxt = weatherTxt;
    }

    public String getWeatherReport() {
        try {
            //weather entity is class used to hold weather information
            WeatherEntity we = new WeatherEntity();
            we.setUnitFlag(WeatherEntity.FLAG_DEG_C);

            //create jsonObject from the JSON string
            JSONObject jsonObject = new JSONObject(this.weatherTxt);
            we.setCity(jsonObject.getString("name")); //gets the name of the city


            JSONObject sysObject = jsonObject.getJSONObject("sys");
            we.setCountryCode(sysObject.getString("country"));

            JSONObject mainObject = jsonObject.getJSONObject("main");
            we.setString(mainObject.getString("temp"));

            return we.toString();
        } catch (JSONException e) {
            return new String(e.toString());
        }
    }

}
