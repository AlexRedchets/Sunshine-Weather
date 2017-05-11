package com.alexredchets.sunshineweather;

import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.WeatherModel.WeatherModel;
import com.alexredchets.sunshineweather.WeatherModel.WeatherModelList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WeatherMapper {

    @Inject
    public WeatherMapper() {
    }

    public List<Weather> mapWeather(WeatherModel response){
        List<Weather> weatherList = new ArrayList<>();

        if (response != null) {
            WeatherModelList[] list = response.getList();
            if (list != null) {
                for (WeatherModelList weatherModelList : list) {
                    Weather weather = new Weather();
                    weather.setDayTemperature((int)weatherModelList.getTemp().getDay());
                    weather.setNightTemperature((int)weatherModelList.getTemp().getNight());
                    weather.setHumidity((int)weatherModelList.getHumidity());
                    weather.setPressure((int)weatherModelList.getPressure());
                    weather.setIconId(String.valueOf(weatherModelList.getWeather()[0].getIcon()));
                    weatherList.add(weather);
                }
            }
        }

        return weatherList;
    }
}
