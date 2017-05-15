package com.alexredchets.sunshineweather.mvp.currentWeather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.data.CurrentWeatherAdapter;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import javax.inject.Inject;

public class CurrentWeatherFragment extends Fragment implements WeatherInterface.CurrentWeatherFragmentInterface {

    private static final String TAG = CurrentWeatherFragment.class.getSimpleName();
    private CurrentWeatherAdapter mAdapter;

    @Inject protected CurrentWeatherPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity()
                .getApplicationContext())
                .provideCurrentWeatherComponent(this)
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_current_weather, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated:");
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new CurrentWeatherAdapter(getActivity(), view);
        mPresenter.fetchData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((App)getActivity()
                .getApplicationContext())
                .releaseCurrentWeatherComponent();
    }

    @Override
    public void onComplete(Weather weather) {
        Log.i(TAG, "onComplete: ");
        mAdapter.updateAdapter(weather);
    }

    @Override
    public void onError(String message) {
        Log.i(TAG, "onError: " + message);
    }
}
