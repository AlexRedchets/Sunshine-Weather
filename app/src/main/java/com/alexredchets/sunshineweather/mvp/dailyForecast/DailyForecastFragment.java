package com.alexredchets.sunshineweather.mvp.dailyForecast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.alexredchets.sunshineweather.data.DailyWeatherAdapter;
import com.alexredchets.sunshineweather.data.HourlyWeatherAdapter;
import com.alexredchets.sunshineweather.mvp.main.WeatherInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyForecastFragment extends Fragment implements WeatherInterface.WeatherFragmentInterface {

    private static final String TAG = DailyForecastFragment.class.getSimpleName();
    private DailyWeatherAdapter mAdapter;
    @BindView(R.id.recycler_view_daily_weather) protected RecyclerView mRecyclerView;
    @Inject protected DailyForecastPresent mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        ((App)getActivity()
                .getApplicationContext())
                .provideWeatherComponent(this)
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
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
        Log.i(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
        mPresenter.fetchData();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
        ((App)getActivity()
                .getApplicationContext())
                .releaseWeatherComponent();
    }

    @Override
    public void onComplete(List<Weather> weatherList) {
        Log.i(TAG, "onComplete: ");
        mAdapter.updateAdapter(weatherList);
    }

    @Override
    public void onError(String message) {
        Log.i(TAG, "onError: " + message);
    }
}
