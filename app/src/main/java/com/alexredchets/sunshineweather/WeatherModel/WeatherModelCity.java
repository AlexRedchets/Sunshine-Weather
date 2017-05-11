package com.alexredchets.sunshineweather.WeatherModel;

public class WeatherModelCity {
    private String country;
    private WeatherModelCityCoord coord;
    private String name;
    private int id;
    private int population;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public WeatherModelCityCoord getCoord() {
        return this.coord;
    }

    public void setCoord(WeatherModelCityCoord coord) {
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
