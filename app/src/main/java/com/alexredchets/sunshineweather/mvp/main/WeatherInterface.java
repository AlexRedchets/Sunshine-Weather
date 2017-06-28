package com.alexredchets.sunshineweather.mvp.main;

import com.alexredchets.sunshineweather.WeatherModel.Weather;

import java.util.List;

public interface WeatherInterface {

    interface WeatherFragmentInterface{

        void onComplete(List<Weather> weatherList);

        void onError(String message);
    }

    interface CurrentWeatherFragmentInterface{

        void onComplete(Weather weather);

        void onError(String message);
    }

    interface WeatherPresenterInterface{

        void fetchData(String lat, String lon);

        void fetchDataDB();
    }

}
