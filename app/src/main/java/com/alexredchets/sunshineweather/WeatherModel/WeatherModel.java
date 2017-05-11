package com.alexredchets.sunshineweather.WeatherModel;

public class WeatherModel {
    private WeatherModelCity city;
    private int cnt;
    private String cod;
    private double message;
    private WeatherModelList[] list;

    public WeatherModelCity getCity() {
        return this.city;
    }

    public void setCity(WeatherModelCity city) {
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

    public WeatherModelList[] getList() {
        return this.list;
    }

    public void setList(WeatherModelList[] list) {
        this.list = list;
    }
}
