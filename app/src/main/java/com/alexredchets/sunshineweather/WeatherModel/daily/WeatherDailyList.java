package com.alexredchets.sunshineweather.WeatherModel.daily;

public class WeatherDailyList {
    private int dt;
    private WeatherDailyListTemp temp;
    private int deg;
    private WeatherDailyListWeather[] weather;
    private int humidity;
    private double pressure;
    private int clouds;
    private double speed;

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public WeatherDailyListTemp getTemp() {
        return this.temp;
    }

    public void setTemp(WeatherDailyListTemp temp) {
        this.temp = temp;
    }

    public int getDeg() {
        return this.deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public WeatherDailyListWeather[] getWeather() {
        return this.weather;
    }

    public void setWeather(WeatherDailyListWeather[] weather) {
        this.weather = weather;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return this.pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getClouds() {
        return this.clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
