package com.alexredchets.sunshineweather.WeatherModel.current;

public class WeatherCurrentSys {
    private String country;
    private double sunrise;
    private double sunset;
    private double id;
    private double type;
    private double message;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return this.sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return this.sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

    public double getId() {
        return this.id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getType() {
        return this.type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public double getMessage() {
        return this.message;
    }

    public void setMessage(double message) {
        this.message = message;
    }
}
