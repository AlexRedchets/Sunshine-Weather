package com.alexredchets.sunshineweather.WeatherModel.daily;

public class WeatherDailyListTemp {
    private double min;
    private int max;
    private int eve;
    private double night;
    private int day;
    private int morn;

    public double getMin() {
        return this.min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getEve() {
        return this.eve;
    }

    public void setEve(int eve) {
        this.eve = eve;
    }

    public double getNight() {
        return this.night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMorn() {
        return this.morn;
    }

    public void setMorn(int morn) {
        this.morn = morn;
    }
}
