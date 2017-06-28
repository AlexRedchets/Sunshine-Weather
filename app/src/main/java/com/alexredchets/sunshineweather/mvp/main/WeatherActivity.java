package com.alexredchets.sunshineweather.mvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.data.DailyWeatherAdapter;
import com.alexredchets.sunshineweather.mvp.currentWeather.CurrentWeatherFragment;
import com.alexredchets.sunshineweather.mvp.dailyForecast.DailyForecastFragment;
import com.alexredchets.sunshineweather.mvp.hourlyForecast.HourlyForecastFragment;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (savedInstanceState == null){
            Log.i(TAG, "onCreate: savedInstanceState == null");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout_current_weather, new CurrentWeatherFragment(), "CurrentWeatherFragment")
                    .replace(R.id.layout_hourly_forecast, new HourlyForecastFragment(), "HourlyForecastFragment")
                    .replace(R.id.layout_daily_forecast, new DailyForecastFragment(), "DailyForecastFragment")
                    .setTransition(0)
                    .commit();
        }
        else {
            Log.i(TAG, "onCreate: savedInstanceState not null");
            CurrentWeatherFragment currentWeatherFragment = (CurrentWeatherFragment)getSupportFragmentManager()
                    .findFragmentByTag("CurrentWeatherFragment");
            HourlyForecastFragment hourlyForecastFragment = (HourlyForecastFragment)getSupportFragmentManager()
                    .findFragmentByTag("HourlyForecastFragment");
            DailyForecastFragment dailyForecastFragment = (DailyForecastFragment)getSupportFragmentManager()
                    .findFragmentByTag("DailyForecastFragment");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplication()).releaseWeatherComponent();
    }
}