package com.naw.dev.androidtutorial;

/**
 * Created by fs on 2015-03-11.
 * <p/>
 * Entity class to hold weather information
 *
 * This class to be expanded in the future
 */
public class WeatherEntity {

    private String temp;
    private String city;
    private String countryCode;

    private static final float ABS_ZERO = -273.15f; //absolute zero, 0 Kelvin

    //flags used set the temperature unit
    public static final int FLAG_DEG_C = 1;
    public static final int FLAG_DEG_K = 2;
   // public static final int FLAG_DEG_F = 3;

    //default flag is FLAG_DEG_C
    private int flag = FLAG_DEG_C;

    public WeatherEntity() {

    }

    public WeatherEntity(String city, String countryCode, String temp) {
        this.city = city;
        this.countryCode = countryCode;
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set static flag telling desired unit
     *
     * */
    public void setUnitFlag(int flag) {
        this.flag = flag;
    }

    /**
     * Returns the Location and the Country code
     */
    public String getLocation() {
        return String.format("%s, %s", this.city, this.countryCode);
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setString(String temp) {
        this.temp = temp;
    }

    public double getTempDegC() {
        return parseTemp(this.temp) + ABS_ZERO;
    }

    public double getTempDegK() {
        return parseTemp(this.temp);
    }

    /*
    public float getTempDegF() {
        return null;
    }
    */

    /**
     * Parse the String temperature to a Double
     *
     * */
    private double parseTemp(String temp) {
        return Double.parseDouble(temp);
    }


    /**
     * Override the toString method to nicely format the data in a string
     *
     * */
    @Override
    public String toString() {
        if (flag == FLAG_DEG_C) {
            return String.format("Location: %s \nTemperature: %.02f degC", getLocation(), getTempDegC());
        } else  {//else if flag == FLAG_DEG_K
            return String.format("Location: %s \nTemperature: %.02f degK", getLocation(), getTempDegK());
        }
    }
}
