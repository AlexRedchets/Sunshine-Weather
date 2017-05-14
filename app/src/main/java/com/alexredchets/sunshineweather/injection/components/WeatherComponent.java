package com.alexredchets.sunshineweather.injection.components;

import com.alexredchets.sunshineweather.injection.modules.WeatherModule;
import com.alexredchets.sunshineweather.injection.scopes.PerActivity;
import com.alexredchets.sunshineweather.mvp.main.WeatherActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = WeatherModule.class)
public interface WeatherComponent {

    WeatherActivity inject (WeatherActivity weatherActivity);

}
