package com.alexredchets.sunshineweather.injection.components;

import com.alexredchets.sunshineweather.injection.modules.AppModule;
import com.alexredchets.sunshineweather.injection.modules.WeatherModule;
import com.alexredchets.sunshineweather.mvp.main.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    WeatherComponent plus (WeatherModule weatherModule);
    void inject (SplashActivity activity);
}
