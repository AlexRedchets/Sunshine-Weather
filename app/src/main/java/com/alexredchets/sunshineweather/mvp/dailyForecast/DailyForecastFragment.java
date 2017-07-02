package com.alexredchets.sunshineweather.mvp.dailyForecast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.data.DailyWeatherAdapter;
import com.alexredchets.sunshineweather.mvp.base.BaseFragment;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class DailyForecastFragment extends BaseFragment implements WeatherInterface.WeatherFragmentInterface {

    private DailyWeatherAdapter mAdapter;
    private String mLatitude;
    private String mLongitude;
    @BindView(R.id.recycler_view_daily_weather) protected RecyclerView mRecyclerView;
    @Inject protected DailyForecastPresent mPresenter;
    @Inject protected SharedPreferences mPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity()
                .getApplicationContext())
                .provideWeatherComponent(this)
                .inject(this);
        mLatitude = mPreferences.getString("latitude", "");
        mLongitude = mPreferences.getString("longitude", "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_daily_forecast, container, false);
        ButterKnife.bind(this, mView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DailyWeatherAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showProgressDialog("Loading data...");
        mPresenter.fetchData(mLatitude, mLongitude);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((App)getActivity()
                .getApplicationContext())
                .releaseWeatherComponent();
    }

    @Override
    public void onComplete(List<Weather> weatherList) {
        hideProgressDialog();
        if (weatherList != null) {
            mAdapter.updateAdapter(weatherList);
        }
        else {
            Toast.makeText(getContext(),
                    "Cannot load data. Please try again.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onError(String message) {
        Timber.e("onError: " + message);
        hideProgressDialog();
        Toast.makeText(getContext(),
                "Cannot load data. Please try again.",
                Toast.LENGTH_SHORT).show();
    }
}
