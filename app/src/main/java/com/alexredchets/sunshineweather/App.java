package com.alexredchets.sunshineweather;

import android.app.Application;

import com.alexredchets.sunshineweather.injection.components.AppComponent;
import com.alexredchets.sunshineweather.injection.components.DaggerAppComponent;
import com.alexredchets.sunshineweather.injection.components.WeatherComponent;
import com.alexredchets.sunshineweather.injection.modules.AppModule;
import com.alexredchets.sunshineweather.injection.modules.WeatherModule;
import com.alexredchets.sunshineweather.mvp.WeatherInterface;

public class App extends Application {

    private AppComponent mAppComponent;
    private WeatherComponent mWeatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this,
                        "http://api.openweathermap.org/data/2.5/forecast/"))
                .build();
    }

    public WeatherComponent provideWeatherComponent(WeatherInterface.WeatherActivityInterface view){
        mWeatherComponent = mAppComponent.plus(new WeatherModule(view));
        return mWeatherComponent;
    }

    public void releaseWeatherComponent(){
        mWeatherComponent = null;
    }

    public AppComponent provideAppComponent(){
        return mAppComponent;
    }
}
