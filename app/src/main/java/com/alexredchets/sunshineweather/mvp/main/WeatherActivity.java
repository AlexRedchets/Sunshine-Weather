package com.alexredchets.sunshineweather.mvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.mvp.currentWeather.CurrentWeatherFragment;
import com.alexredchets.sunshineweather.mvp.hourlyForecast.HourlyForecastFragment;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (savedInstanceState == null){
            Log.e(TAG, "savedInstanceState == null");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layout_current_weather, new CurrentWeatherFragment())
                    .add(R.id.layout_hourly_forecast, new HourlyForecastFragment())
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplication()).releaseWeatherComponent();
    }
}