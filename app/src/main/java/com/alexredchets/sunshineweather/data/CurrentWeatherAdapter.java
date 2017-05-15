package com.alexredchets.sunshineweather.data;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentWeatherAdapter {

    private static final String TAG = CurrentWeatherAdapter.class.getSimpleName();

    @BindView(R.id.text_view_weather_temperature) protected TextView mTextViewTemp;
    @BindView(R.id.text_view_weather_city) protected TextView mTextViewCity;
    @BindView(R.id.text_view_weather_country) protected TextView mTextViewCountry;
    @BindView(R.id.text_view_weather_date) protected TextView mTextViewDate;
    @BindView(R.id.text_view_weather_humidity) protected TextView mTextViewHumidity;
    @BindView(R.id.text_view_weather_pressure) protected TextView mTextViewPressure;
    @BindView(R.id.text_view_weather_wind) protected TextView mTextViewWind;
    @BindView(R.id.image_view_weather_icon) protected ImageView mImageViewIcon;

    Context mContext;
    View mView;

    public CurrentWeatherAdapter(Context mContext, View mView) {
        this.mView = mView;
        this.mContext = mContext;
        ButterKnife.bind(this, mView);
    }

    public void updateAdapter(Weather mWeather){
        Log.i(TAG, "updateAdapter: ");
        mTextViewTemp.setText(String.valueOf(mWeather.getDayTemperature()));
        mTextViewHumidity.setText(String.valueOf(mWeather.getHumidity()));
        mTextViewPressure.setText(String.valueOf(mWeather.getPressure()));
        mTextViewWind.setText(String.valueOf(mWeather.getWindSpeed()));
        Glide
                .with(mContext)
                .load("http://openweathermap.org/img/w/" + mWeather.getIconId() + ".png")
                .into(mImageViewIcon);
    }
}

