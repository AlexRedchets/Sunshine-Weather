package com.alexredchets.sunshineweather.WeatherModel.daily;

public class WeatherDailyCity {
    private String country;
    private WeatherDailyCityCoord coord;
    private String name;
    private int id;
    private int population;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public WeatherDailyCityCoord getCoord() {
        return this.coord;
    }

    public void setCoord(WeatherDailyCityCoord coord) {
        this.coord = coord;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
