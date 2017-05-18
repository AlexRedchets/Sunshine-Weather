package com.alexredchets.sunshineweather;


import com.alexredchets.sunshineweather.WeatherModel.current.WeatherCurrent;
import com.alexredchets.sunshineweather.WeatherModel.daily.WeatherDaily;
import com.alexredchets.sunshineweather.WeatherModel.hourly.WeatherHourly;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather?")
    Observable<WeatherCurrent> getCurrentWeather(
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("units") String units,
            @Query("appid") String appid
    );

    @GET("forecast?")
    Observable<WeatherHourly> getHourlyWeather(
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("cnt") int cnt,
            @Query("units") String units,
            @Query("appid") String appid
    );

    @GET("forecast/daily?")
    Observable<WeatherDaily> getDailyWeather(
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("cnt") int cnt,
            @Query("units") String units,
            @Query("appid") String appid
    );
}
