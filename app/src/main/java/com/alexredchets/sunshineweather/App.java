package com.alexredchets.sunshineweather;

import android.app.Application;

import com.alexredchets.sunshineweather.injection.components.AppComponent;
import com.alexredchets.sunshineweather.injection.components.DaggerAppComponent;
import com.alexredchets.sunshineweather.injection.components.WeatherComponent;
import com.alexredchets.sunshineweather.injection.modules.AppModule;
import com.alexredchets.sunshineweather.injection.modules.WeatherModule;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

public class App extends Application {

    private AppComponent mAppComponent;
    private WeatherComponent mCurrentWeatherComponent;
    private WeatherComponent mWeatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this,
                        "http://api.openweathermap.org/data/2.5/"))
                .build();
    }

    public AppComponent provideAppComponent(){
        return mAppComponent;
    }

    public WeatherComponent provideCurrentWeatherComponent(WeatherInterface.CurrentWeatherFragmentInterface view){
        mCurrentWeatherComponent = mAppComponent.plus(new WeatherModule(view));
        return mCurrentWeatherComponent;
    }

    public WeatherComponent provideWeatherComponent(WeatherInterface.WeatherFragmentInterface view){
        mWeatherComponent = mAppComponent.plus(new WeatherModule(view));
        return mWeatherComponent;
    }

    public void releaseCurrentWeatherComponent(){
        mCurrentWeatherComponent = null;
    }

    public void releaseWeatherComponent(){
        mWeatherComponent = null;
    }
}
