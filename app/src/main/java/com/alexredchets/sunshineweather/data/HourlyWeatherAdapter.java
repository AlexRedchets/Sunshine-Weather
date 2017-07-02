package com.alexredchets.sunshineweather.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexredchets.sunshineweather.R;
import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.ViewHolder> {

    private Context mContext;
    private List<Weather> mWeatherList;

    public HourlyWeatherAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void updateAdapter(List<Weather> weatherList) {
        this.mWeatherList = weatherList;
        notifyDataSetChanged();
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

        holder.textViewTemperature.setText(String.valueOf(weather.getDayTemperature()));
        holder.textViewDate.setText(String.valueOf(weather.getDt()));
        String dateString = new SimpleDateFormat("h aaa", Locale.getDefault()).format(new Date(weather.getDt()*1000));
        holder.textViewDate.setText(dateString);
        Glide
                .with(mContext)
                .load("http://104.131.37.13:8888/routes/image/" + weather.getIconId())
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