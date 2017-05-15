package com.alexredchets.sunshineweather.mvp.hourlyForecast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import java.util.List;

import javax.inject.Inject;

public class HourlyForecastFragment extends Fragment implements WeatherInterface.WeatherFragmentInterface{

    private static final String TAG = HourlyForecastFragment.class.getSimpleName();

    @Inject protected HourlyForecastPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hourly_forecast, container, false);
    }

    @Override
    public void onComplete(List<Weather> weatherList) {

    }

    @Override
    public void onError(String message) {

    }
}