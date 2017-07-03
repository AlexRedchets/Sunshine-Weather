package com.alexredchets.sunshine.injection.components;

import com.alexredchets.sunshine.injection.modules.AppModule;
import com.alexredchets.sunshine.injection.modules.WeatherModule;
import com.alexredchets.sunshine.mvp.main.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    WeatherComponent plus(WeatherModule weatherModule);
    void inject(SplashActivity activity);
}
