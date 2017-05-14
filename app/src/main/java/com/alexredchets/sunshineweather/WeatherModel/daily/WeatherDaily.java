package com.alexredchets.sunshineweather.WeatherModel.daily;

public class WeatherDaily {
    private WeatherDailyCity city;
    private int cnt;
    private String cod;
    private double message;
    private WeatherDailyList[] list;

    public WeatherDailyCity getCity() {
        return this.city;
    }

    public void setCity(WeatherDailyCity city) {
        this.city = city;
    }

    public int getCnt() {
        return this.cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return this.message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public WeatherDailyList[] getList() {
        return this.list;
    }

    public void setList(WeatherDailyList[] list) {
        this.list = list;
    }
}
