package com.alexredchets.sunshine.injection.modules;

import com.alexredchets.sunshine.injection.scopes.PerActivity;
import com.alexredchets.sunshine.mvp.main.WeatherInterface;

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