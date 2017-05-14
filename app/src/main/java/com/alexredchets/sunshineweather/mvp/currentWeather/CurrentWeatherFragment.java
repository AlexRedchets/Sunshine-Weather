package com.alexredchets.sunshineweather.mvp.currentWeather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import javax.inject.Inject;

public class CurrentWeatherFragment extends Fragment implements WeatherInterface.CurrentWeatherFragmentInterface {

    private static final String TAG = CurrentWeatherFragment.class.getSimpleName();

    @Inject protected CurrentWeatherPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_current_weather, container, false);
    }

    @Override
    public void onComplete(Weather weather) {

    }

    @Override
    public void onError(String message) {

    }
}
