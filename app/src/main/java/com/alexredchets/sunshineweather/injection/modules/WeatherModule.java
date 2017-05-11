package com.alexredchets.sunshineweather.injection.modules;

import com.alexredchets.sunshineweather.injection.scopes.PerActivity;
import com.alexredchets.sunshineweather.mvp.WeatherInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {

    private WeatherInterface.WeatherActivityInterface view;

    public WeatherModule(WeatherInterface.WeatherActivityInterface view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    WeatherInterface.WeatherActivityInterface getView(){
        return view;
    }

}
