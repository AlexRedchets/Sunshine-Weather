package com.alexredchets.sunshine.WeatherModel.hourly;

public class WeatherHourly {
    private WeatherHourlyCity city;
    private int cnt;
    private String cod;
    private double message;
    private WeatherHourlyList[] list;

    public WeatherHourlyCity getCity() {
        return this.city;
    }

    public void setCity(WeatherHourlyCity city) {
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

    public WeatherHourlyList[] getList() {
        return this.list;
    }

    public void setList(WeatherHourlyList[] list) {
        this.list = list;
    }
}
