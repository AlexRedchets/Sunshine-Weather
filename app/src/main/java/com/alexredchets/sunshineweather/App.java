package com.alexredchets.sunshineweather;

import android.app.Application;
import android.content.Context;

import com.alexredchets.sunshineweather.injection.components.AppComponent;
import com.alexredchets.sunshineweather.injection.components.DaggerAppComponent;
import com.alexredchets.sunshineweather.injection.components.WeatherComponent;
import com.alexredchets.sunshineweather.injection.modules.AppModule;
import com.alexredchets.sunshineweather.injection.modules.WeatherModule;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes
public class App extends Application {

    private AppComponent mAppComponent;
    private WeatherComponent mCurrentWeatherComponent;
    private WeatherComponent mWeatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        provideAppComponent();
    }

    public AppComponent provideAppComponent(){
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this,
                        "http://api.openweathermap.org/data/2.5/"))
                .build();
        return mAppComponent;
    }

    public void releaseAppComponent(){
        mAppComponent = null;
    }

    public WeatherComponent provideCurrentWeatherComponent(WeatherInterface.CurrentWeatherFragmentInterface view){
        if (mAppComponent == null) {
            provideAppComponent();
        }
        mCurrentWeatherComponent = mAppComponent.plus(new WeatherModule(view));
        return mCurrentWeatherComponent;
    }

    public WeatherComponent provideWeatherComponent(WeatherInterface.WeatherFragmentInterface view){
        if (mAppComponent == null) {
            provideAppComponent();
        }
        mWeatherComponent = mAppComponent.plus(new WeatherModule(view));
        return mWeatherComponent;
    }

    public void releaseCurrentWeatherComponent(){
        mCurrentWeatherComponent = null;
    }

    public void releaseWeatherComponent(){
        mWeatherComponent = null;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ACRA.init(this);
    }
}