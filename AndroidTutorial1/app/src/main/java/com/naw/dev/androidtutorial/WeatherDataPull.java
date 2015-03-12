package com.naw.dev.androidtutorial;

import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by fs on 2015-03-10.
 * <p/>
 * AsyncTask<input type, updater type (ignore in this case), return type>
 * <p/>
 * This class does a http request and pulls the json weather data provided by the open weather api
 * <p/>
 * NOTE: this class is Asynchronous and DOES NOT run on the application UI (User Interface) thread. Simple put, the
 * UI does get held up when this class calls execute
 */
public class WeatherDataPull extends AsyncTask<String, Void, String> {

    //base url of api
    //you append the location you wish to access the weather for at the end of this link
    private static final String baseUrl = "http://api.openweathermap.org/data/2.5/weather?q=";

    private TextView tvWeather;

    /**
     * Class constructor
     *
     * @param tvWeather TextView you used to display the weather information
     */
    public WeatherDataPull(TextView tvWeather) {
        this.tvWeather = tvWeather;
    }

    @Override
    protected String doInBackground(String... params) {
        //access the param passed into the method execute
        String location = params[0];

        //append the location to the baseUrl
        String url = baseUrl + location;

        try {
            //the following is how to make a network request
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);

            //get the status of the request
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            //status Code 200 means the request was successful
            if (statusCode == 200) {
                //BufferedReader and InputStreamRead are used to read the data output from
                //the network request
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent()));

                //create a StringBuffer to append all the data to
                StringBuffer sb = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close(); //close BufferedReader
                return sb.toString(); //create string from StringBuffer

            } else {
                return new String("Error in downloading");
            }

        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }


    /**
     * This method is called once the doInBackground method has finished
     *
     * */
    @Override
    protected void onPostExecute(String s) {
        try {
            //create object to parse the data json data from the network pull
            WeatherParserJSON parser = new WeatherParserJSON(s);
            tvWeather.setText(parser.getWeatherReport());
        } catch (Exception e) {
            tvWeather.setText("No Location found");
        }

    }

}
