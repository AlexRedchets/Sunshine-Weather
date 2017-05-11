package com.alexredchets.sunshineweather.mvp;

import com.alexredchets.sunshineweather.WeatherModel.Weather;

import java.util.List;

public interface WeatherInterface {

    interface WeatherActivityInterface{

        void onComplete(List<Weather> weatherList);

        void onError(String message);
    }

    interface WeatherPresenterInterface{

        void fetchData();

        void fetchDataDB();
    }

}
