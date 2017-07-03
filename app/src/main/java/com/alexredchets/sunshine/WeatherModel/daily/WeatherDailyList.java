package com.alexredchets.sunshine.WeatherModel.daily;

public class WeatherDailyList {
    private int dt;
    private WeatherDailyListTemp temp;
    private double deg;
    private WeatherDailyListWeather[] weather;
    private double humidity;
    private double pressure;
    private double clouds;
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

    public double getDeg() {
        return this.deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public WeatherDailyListWeather[] getWeather() {
        return this.weather;
    }

    public void setWeather(WeatherDailyListWeather[] weather) {
        this.weather = weather;
    }

    public double getHumidity() {
        return this.humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return this.pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getClouds() {
        return this.clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
