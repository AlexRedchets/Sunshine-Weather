package com.alexredchets.sunshineweather.mvp.dailyForecast;

import android.util.Log;

import com.alexredchets.sunshineweather.WeatherApi;
import com.alexredchets.sunshineweather.WeatherMapper;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class DailyForecastPresent implements WeatherInterface.WeatherPresenterInterface {

    private static final String TAG = DailyForecastPresent.class.getSimpleName();
    private Retrofit mRetrofit;
    private WeatherInterface.WeatherFragmentInterface mView;

    @Inject
    public DailyForecastPresent(Retrofit mRetrofit,
                                WeatherInterface.WeatherFragmentInterface mView) {
        this.mRetrofit = mRetrofit;
        this.mView = mView;
    }

    @Inject
    protected WeatherMapper mWeatherMapper;

    @Override
    public void fetchData(String lat, String lon) {

        Log.i(TAG, "fetchData started");

        mRetrofit.create(WeatherApi.class).getDailyWeather(lat,
                lon,
                10,
                "metric",
                "d73975775ce9c90c9b05799d119ef5e9")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.e(TAG, "Successfully got data");

                            List<Weather> mWeatherList = mWeatherMapper.mapDailyWeather(response);
                            mView.onComplete(mWeatherList);
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());

                            mView.onError(throwable.getMessage());
                        });

    }

    @Override
    public void fetchDataDB() {

    }
}
