package com.alexredchets.sunshineweather.WeatherModel.current;

public class WeatherCurrent {
    private int dt;
    private WeatherCurrentCoord coord;
    private int visibility;
    private WeatherCurrentWeather[] weather;
    private String name;
    private int cod;
    private WeatherCurrentMain main;
    private WeatherCurrentClouds clouds;
    private int id;
    private WeatherCurrentSys sys;
    private String base;
    private WeatherCurrentWind wind;

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public WeatherCurrentCoord getCoord() {
        return this.coord;
    }

    public void setCoord(WeatherCurrentCoord coord) {
        this.coord = coord;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public WeatherCurrentWeather[] getWeather() {
        return this.weather;
    }

    public void setWeather(WeatherCurrentWeather[] weather) {
        this.weather = weather;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public WeatherCurrentMain getMain() {
        return this.main;
    }

    public void setMain(WeatherCurrentMain main) {
        this.main = main;
    }

    public WeatherCurrentClouds getClouds() {
        return this.clouds;
    }

    public void setClouds(WeatherCurrentClouds clouds) {
        this.clouds = clouds;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeatherCurrentSys getSys() {
        return this.sys;
    }

    public void setSys(WeatherCurrentSys sys) {
        this.sys = sys;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherCurrentWind getWind() {
        return this.wind;
    }

    public void setWind(WeatherCurrentWind wind) {
        this.wind = wind;
    }
}
