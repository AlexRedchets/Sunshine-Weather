package com.alexredchets.sunshine;

import com.alexredchets.sunshine.WeatherModel.Weather;
import com.alexredchets.sunshine.WeatherModel.current.WeatherCurrent;
import com.alexredchets.sunshine.WeatherModel.daily.WeatherDaily;
import com.alexredchets.sunshine.WeatherModel.daily.WeatherDailyList;
import com.alexredchets.sunshine.WeatherModel.hourly.WeatherHourly;
import com.alexredchets.sunshine.WeatherModel.hourly.WeatherHourlyList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WeatherMapper {

    @Inject
    public WeatherMapper() {
    }

    public Weather mapCurrentWeather(WeatherCurrent response){
        Weather mWeather = new Weather();

        if (response != null) {
            mWeather.setDayTemperature((int)response.getMain().getTemp());
            mWeather.setHumidity((int)response.getMain().getHumidity());
            mWeather.setWindSpeed((int)response.getWind().getSpeed());
            mWeather.setPressure((int)response.getMain().getPressure());
            mWeather.setCityName(response.getName());
            mWeather.setCountryCode(response.getSys().getCountry());
            mWeather.setIconId(response.getWeather()[0].getIcon());
            mWeather.setDt(response.getDt());
        }

        return mWeather;
    }

    public List<Weather> mapDailyWeather(WeatherDaily response){
        List<Weather> weatherList = new ArrayList<>();

        if (response != null) {
            WeatherDailyList[] list = response.getList();
            if (list != null) {
                for (com.alexredchets.sunshine.WeatherModel.daily.WeatherDailyList WeatherDailyList : list) {
                    Weather weather = new Weather();
                    weather.setDayTemperature((int)WeatherDailyList.getTemp().getDay());
                    weather.setNightTemperature((int)WeatherDailyList.getTemp().getNight());
                    weather.setHumidity((int)WeatherDailyList.getHumidity());
                    weather.setPressure((int)WeatherDailyList.getPressure());
                    weather.setIconId(String.valueOf(WeatherDailyList.getWeather()[0].getIcon()));
                    weather.setDt(WeatherDailyList.getDt());
                    weatherList.add(weather);
                }
            }
        }

        return weatherList;
    }

    public List<Weather> mapHourlyWeather(WeatherHourly response){
        List<Weather> weatherList = new ArrayList<>();

        if (response != null) {
            WeatherHourlyList[] list = response.getList();
            if (list != null) {
                for (com.alexredchets.sunshine.WeatherModel.hourly.WeatherHourlyList WeatherHourlyList : list){
                    Weather weather = new Weather();
                    weather.setDayTemperature((int)WeatherHourlyList.getMain().getTemp());
                    weather.setHumidity((int)WeatherHourlyList.getMain().getHumidity());
                    weather.setPressure((int)WeatherHourlyList.getMain().getPressure());
                    weather.setIconId(String.valueOf(WeatherHourlyList.getWeather()[0].getIcon()));
                    weather.setDt(WeatherHourlyList.getDt());
                    weatherList.add(weather);
                }
            }
        }

        return weatherList;
    }
}