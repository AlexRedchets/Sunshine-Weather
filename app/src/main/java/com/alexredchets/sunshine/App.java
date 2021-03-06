package com.alexredchets.sunshine;

import android.app.Application;

import com.alexredchets.sunshine.injection.components.AppComponent;
import com.alexredchets.sunshine.injection.components.WeatherComponent;
import com.alexredchets.sunshine.injection.modules.AppModule;
import com.alexredchets.sunshine.injection.modules.WeatherModule;
import com.alexredchets.sunshine.mvp.main.WeatherInterface;
import com.alexredchets.sunshine.BuildConfig;
import com.alexredchets.sunshine.injection.components.DaggerAppComponent;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class App extends Application {

    private AppComponent mAppComponent;
    private WeatherComponent mCurrentWeatherComponent;
    private WeatherComponent mWeatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree(){
                //Add the line number to the tag
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ": Line " + element.getLineNumber();
                }
            });
        }
        else {
            //Release mode
            Fabric.with(this, new Crashlytics());
            Timber.plant(new ReleaseTree());
        }

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
}