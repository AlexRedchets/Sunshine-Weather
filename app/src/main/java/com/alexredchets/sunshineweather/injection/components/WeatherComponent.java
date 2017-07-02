package com.alexredchets.sunshineweather.injection.components;

import com.alexredchets.sunshineweather.injection.modules.WeatherModule;
import com.alexredchets.sunshineweather.injection.scopes.PerActivity;
import com.alexredchets.sunshineweather.mvp.currentWeather.CurrentWeatherFragment;
import com.alexredchets.sunshineweather.mvp.dailyForecast.DailyForecastFragment;
import com.alexredchets.sunshineweather.mvp.hourlyForecast.HourlyForecastFragment;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = WeatherModule.class)
public interface WeatherComponent {
    CurrentWeatherFragment inject (CurrentWeatherFragment fragment);
    DailyForecastFragment inject (DailyForecastFragment fragment);
    HourlyForecastFragment inject (HourlyForecastFragment fragment);
}
