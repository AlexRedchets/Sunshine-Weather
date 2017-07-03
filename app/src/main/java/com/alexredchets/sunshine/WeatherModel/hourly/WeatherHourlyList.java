package com.alexredchets.sunshine.WeatherModel.hourly;

public class WeatherHourlyList {
    private int dt;
    private String dt_txt;
    private WeatherHourlyListWeather[] weather;
    private WeatherHourlyListMain main;
    private WeatherHourlyListClouds clouds;
    private WeatherHourlyListSys sys;
    private WeatherHourlyListWind wind;

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public String getDt_txt() {
        return this.dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public WeatherHourlyListWeather[] getWeather() {
        return this.weather;
    }

    public void setWeather(WeatherHourlyListWeather[] weather) {
        this.weather = weather;
    }

    public WeatherHourlyListMain getMain() {
        return this.main;
    }

    public void setMain(WeatherHourlyListMain main) {
        this.main = main;
    }

    public WeatherHourlyListClouds getClouds() {
        return this.clouds;
    }

    public void setClouds(WeatherHourlyListClouds clouds) {
        this.clouds = clouds;
    }

    public WeatherHourlyListSys getSys() {
        return this.sys;
    }

    public void setSys(WeatherHourlyListSys sys) {
        this.sys = sys;
    }

    public WeatherHourlyListWind getWind() {
        return this.wind;
    }

    public void setWind(WeatherHourlyListWind wind) {
        this.wind = wind;
    }
}
