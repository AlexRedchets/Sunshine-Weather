package com.alexredchets.sunshine.injection.components;

import com.alexredchets.sunshine.injection.modules.WeatherModule;
import com.alexredchets.sunshine.injection.scopes.PerActivity;
import com.alexredchets.sunshine.mvp.currentWeather.CurrentWeatherFragment;
import com.alexredchets.sunshine.mvp.dailyForecast.DailyForecastFragment;
import com.alexredchets.sunshine.mvp.hourlyForecast.HourlyForecastFragment;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = WeatherModule.class)
public interface WeatherComponent {
    CurrentWeatherFragment inject(CurrentWeatherFragment fragment);
    DailyForecastFragment inject(DailyForecastFragment fragment);
    HourlyForecastFragment inject(HourlyForecastFragment fragment);
}
