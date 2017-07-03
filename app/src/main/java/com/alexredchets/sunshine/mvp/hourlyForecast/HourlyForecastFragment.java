package com.alexredchets.sunshine.mvp.hourlyForecast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexredchets.sunshine.App;
import com.alexredchets.sunshine.WeatherModel.Weather;
import com.alexredchets.sunshine.data.HourlyWeatherAdapter;
import com.alexredchets.sunshine.mvp.base.BaseFragment;
import com.alexredchets.sunshine.mvp.main.WeatherInterface;
import com.alexredchets.sunshine.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HourlyForecastFragment extends BaseFragment implements WeatherInterface.WeatherFragmentInterface{

    private HourlyWeatherAdapter mAdapter;
    private String mLatitude;
    private String mLongitude;
    @BindView(R.id.recycler_view_hourly_weather) protected RecyclerView mRecyclerView;

    @Inject protected HourlyForecastPresenter mPresenter;
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
        View mView = inflater.inflate(R.layout.fragment_hourly_forecast, container, false);
        ButterKnife.bind(this, mView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HourlyWeatherAdapter(getContext());
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