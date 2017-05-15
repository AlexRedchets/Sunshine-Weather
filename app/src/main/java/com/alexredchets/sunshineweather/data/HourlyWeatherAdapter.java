package com.alexredchets.sunshineweather.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.ViewHolder> {

    private static final String TAG = HourlyWeatherAdapter.class.getSimpleName();
    private Context mContext;
    private List<Weather> mWeatherList;

    public HourlyWeatherAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void updateAdapter(List<Weather> weatherList) {
        this.mWeatherList = weatherList;
        notifyDataSetChanged();
        Log.i(TAG, "Adapter is updated");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.item_hourly_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Weather weather = mWeatherList.get(position);

        holder.textViewTemperature.setText(weather.getDayTemperature() + " °C");
        holder.textViewDate.setText(String.valueOf(weather.getDt()));
        Glide
                .with(mContext)
                .load("http://openweathermap.org/img/w/" + weather.getIconId() + ".png")
                .into(holder.imageViewWeather);
    }

    @Override
    public int getItemCount() {
        return mWeatherList != null ? mWeatherList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_hourly_weather_temperature) protected TextView textViewTemperature;
        @BindView(R.id.text_view_hourly_weather_date) protected TextView textViewDate;
        @BindView(R.id.image_view_hourly_weather_icon) protected ImageView imageViewWeather;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
