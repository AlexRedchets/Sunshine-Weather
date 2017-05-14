package com.alexredchets.sunshineweather.WeatherModel.hourly;

public class WeatherHourlyCity {
    private String country;
    private WeatherHourlyCityCoord coord;
    private String name;
    private int id;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public WeatherHourlyCityCoord getCoord() {
        return this.coord;
    }

    public void setCoord(WeatherHourlyCityCoord coord) {
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
}
