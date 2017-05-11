package com.alexredchets.sunshineweather.mvp;

import android.util.Log;

import com.alexredchets.sunshineweather.WeatherApi;
import com.alexredchets.sunshineweather.WeatherMapper;
import com.alexredchets.sunshineweather.WeatherModel.Weather;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class WeatherPresenter implements WeatherInterface.WeatherPresenterInterface{

    private static final String TAG = WeatherPresenter.class.getSimpleName();
    private Retrofit retrofit;
    private WeatherInterface.WeatherActivityInterface view;

    @Inject protected WeatherMapper mWeatherMapper;

    @Inject
    public WeatherPresenter(Retrofit retrofit, WeatherInterface.WeatherActivityInterface view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void fetchData() {
        Log.i(TAG, "fetchData started");

        retrofit.create(WeatherApi.class).getWeather("52.051503",
                "113.471191",
                "metric",
                "1fcad98585808b3ca4990830bc17bd16")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.e(TAG, "Successfully got data");

                            List<Weather> weatherList = mWeatherMapper.mapWeather(response);
                            view.onComplete(weatherList);
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());

                            view.onError(throwable.getMessage());
                        });
    }

    @Override
    public void fetchDataDB() {

    }
}
