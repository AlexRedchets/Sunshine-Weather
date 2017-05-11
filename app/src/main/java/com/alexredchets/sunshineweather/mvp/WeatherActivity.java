package com.alexredchets.sunshineweather.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherAdapter;
import com.alexredchets.sunshineweather.WeatherModel.Weather;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements WeatherInterface.WeatherActivityInterface, WeatherAdapter.ClickListener {

    private static final String TAG = WeatherActivity.class.getSimpleName();

    @Inject protected WeatherPresenter mWeatherPresenter;

    @BindView(R.id.recycler_view_weather_list) protected RecyclerView mRecyclerView;

    private WeatherAdapter mWeatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ((App)getApplication()).provideWeatherComponent(this).inject(this);
        ButterKnife.bind(this);

        initializeRecyclerView();

        mWeatherPresenter.fetchData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplication()).releaseWeatherComponent();
    }

    private void initializeRecyclerView() {
        Log.i(TAG, "initializeRecyclerView: ");
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
        mWeatherAdapter = new WeatherAdapter(this, this);
        mRecyclerView.setAdapter(mWeatherAdapter);

    }

    @Override
    public void onClick(Weather weather) {
        Toast.makeText(this, weather.getDayTemperature(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(List<Weather> weatherList) {
        Log.i(TAG, "onComplete: ");
        mWeatherAdapter.updateAdapter(weatherList);
    }

    @Override
    public void onError(String message) {

    }
}
