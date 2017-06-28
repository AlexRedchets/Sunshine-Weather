package com.alexredchets.sunshineweather.mvp.currentWeather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.data.CurrentWeatherAdapter;
import com.alexredchets.sunshineweather.mvp.base.BaseFragment;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import javax.inject.Inject;

public class CurrentWeatherFragment extends BaseFragment implements WeatherInterface.CurrentWeatherFragmentInterface {

    private static final String TAG = CurrentWeatherFragment.class.getSimpleName();
    private CurrentWeatherAdapter mAdapter;
    private String mLatitude;
    private String mLongitude;


    @Inject protected CurrentWeatherPresenter mPresenter;
    @Inject protected SharedPreferences mPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        ((App)getActivity()
                .getApplicationContext())
                .provideCurrentWeatherComponent(this)
                .inject(this);
        mLatitude = mPreferences.getString("latitude", "");
        mLongitude = mPreferences.getString("longitude", "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_current_weather, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated:");
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new CurrentWeatherAdapter(getActivity(), view);
        showProgressDialog("Loading data...");
        mPresenter.fetchData(mLatitude, mLongitude);
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
        hideProgressDialog();
        if (weather != null) {
            mAdapter.updateAdapter(weather);
        }
        else {
            Toast.makeText(getContext(),
                    "Cannot load data. Please try again.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(String message) {
        Log.i(TAG, "onError: " + message);
        hideProgressDialog();
        Toast.makeText(getContext(),
                "Cannot load data. Please try again.",
                Toast.LENGTH_SHORT).show();
    }
}
