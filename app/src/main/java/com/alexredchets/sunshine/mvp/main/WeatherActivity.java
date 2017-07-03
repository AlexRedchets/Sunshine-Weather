package com.alexredchets.sunshine.mvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alexredchets.sunshine.App;
import com.alexredchets.sunshine.mvp.currentWeather.CurrentWeatherFragment;
import com.alexredchets.sunshine.mvp.dailyForecast.DailyForecastFragment;
import com.alexredchets.sunshine.mvp.hourlyForecast.HourlyForecastFragment;
import com.alexredchets.sunshine.R;

import timber.log.Timber;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.i("OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (savedInstanceState == null){
            Timber.i("onCreate: savedInstanceState == null");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout_current_weather, new CurrentWeatherFragment(), "CurrentWeatherFragment")
                    .replace(R.id.layout_hourly_forecast, new HourlyForecastFragment(), "HourlyForecastFragment")
                    .replace(R.id.layout_daily_forecast, new DailyForecastFragment(), "DailyForecastFragment")
                    .setTransition(0)
                    .commit();
        }
        else {
            Timber.i("onCreate: savedInstanceState not null");
            getSupportFragmentManager()
                    .findFragmentByTag("CurrentWeatherFragment");
            getSupportFragmentManager()
                    .findFragmentByTag("HourlyForecastFragment");
            getSupportFragmentManager()
                    .findFragmentByTag("DailyForecastFragment");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplication()).releaseWeatherComponent();
    }
}