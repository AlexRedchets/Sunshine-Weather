package com.alexredchets.sunshineweather.WeatherModel;

public class WeatherModelList {
    private int dt;
    private double rain;
    private WeatherModelListTemp temp;
    private double snow;
    private int deg;
    private WeatherModelListWeather[] weather;
    private double humidity;
    private double pressure;
    private int clouds;
    private double speed;

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public double getRain() {
        return this.rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public WeatherModelListTemp getTemp() {
        return this.temp;
    }

    public void setTemp(WeatherModelListTemp temp) {
        this.temp = temp;
    }

    public double getSnow() {
        return this.snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    public int getDeg() {
        return this.deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public WeatherModelListWeather[] getWeather() {
        return this.weather;
    }

    public void setWeather(WeatherModelListWeather[] weather) {
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
