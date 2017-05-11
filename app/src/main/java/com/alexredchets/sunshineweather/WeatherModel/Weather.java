package com.alexredchets.sunshineweather.WeatherModel;

public class Weather {

    private int dayTemperature;
    private int nightTemperature;
    private int windSpeed;
    private int humidity;
    private int pressure;
    private String iconId;

    public Weather() {}

    public int getDayTemperature() {
        return dayTemperature;
    }

    public void setDayTemperature(int dayTemperature) {
        this.dayTemperature = dayTemperature;
    }

    public int getNightTemperature() {
        return nightTemperature;
    }

    public void setNightTemperature(int nightTemperature) {
        this.nightTemperature = nightTemperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }
}
