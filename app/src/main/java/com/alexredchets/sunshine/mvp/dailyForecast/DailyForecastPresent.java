package com.alexredchets.sunshine.mvp.dailyForecast;

import com.alexredchets.sunshine.WeatherApi;
import com.alexredchets.sunshine.WeatherMapper;
import com.alexredchets.sunshine.WeatherModel.Weather;
import com.alexredchets.sunshine.mvp.main.WeatherInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import timber.log.Timber;

public class DailyForecastPresent implements WeatherInterface.WeatherPresenterInterface {

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

        mRetrofit.create(WeatherApi.class).getDailyWeather(lat,
                lon,
                10,
                "metric",
                "d73975775ce9c90c9b05799d119ef5e9")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Timber.i("Successfully got data");

                            List<Weather> mWeatherList = mWeatherMapper.mapDailyWeather(response);
                            mView.onComplete(mWeatherList);
                        },
                        throwable -> {
                            Timber.e(throwable);

                            mView.onError(throwable.getMessage());
                        });

    }

    @Override
    public void fetchDataDB() {

    }
}