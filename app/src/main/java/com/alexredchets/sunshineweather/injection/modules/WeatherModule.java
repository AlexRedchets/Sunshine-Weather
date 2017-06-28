package com.alexredchets.sunshineweather.injection.modules;

import com.alexredchets.sunshineweather.injection.scopes.PerActivity;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {

    private WeatherInterface.WeatherFragmentInterface mView;
    private WeatherInterface.CurrentWeatherFragmentInterface mCurrentWeatherView;

    public WeatherModule(WeatherInterface.WeatherFragmentInterface view) {
        this.mView = view;
    }

    public WeatherModule(WeatherInterface.CurrentWeatherFragmentInterface currentWeatherView) {
        this.mCurrentWeatherView = currentWeatherView;
    }

    @Provides
    @PerActivity
    WeatherInterface.WeatherFragmentInterface provideView(){
        return mView;
    }

    @Provides
    @PerActivity
    WeatherInterface.CurrentWeatherFragmentInterface provideCurrentWeatherView(){
        return mCurrentWeatherView;
    }
}
