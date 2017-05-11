package com.alexredchets.sunshineweather;

import com.alexredchets.sunshineweather.WeatherModel.WeatherModel;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("daily?")
    Observable<WeatherModel> getWeather(
            @Query("latitude") String latitude,
            @Query("longitude") String longitude,
            @Query("units") String units,
            @Query("appid") String appid
    );
}
