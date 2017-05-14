package com.alexredchets.sunshineweather.injection.modules;

import com.alexredchets.sunshineweather.injection.scopes.PerActivity;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {

    private WeatherInterface.WeatherFragmentInterface view;
    private WeatherInterface.CurrentWeatherFragmentInterface currentWeatherView;

    public WeatherModule(WeatherInterface.WeatherFragmentInterface view,
                         WeatherInterface.CurrentWeatherFragmentInterface currentWeatherView) {
        this.view = view;
        this.currentWeatherView = currentWeatherView;
    }

    @Provides
    @PerActivity
    WeatherInterface.WeatherFragmentInterface getView(){
        return view;
    }

    @Provides
    @PerActivity
    WeatherInterface.CurrentWeatherFragmentInterface getcurrentWeatherView(){
        return currentWeatherView;
    }

}
