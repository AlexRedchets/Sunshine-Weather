package com.alexredchets.sunshineweather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexredchets.sunshineweather.WeatherModel.Weather;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private static final String TAG = WeatherAdapter.class.getSimpleName();
    private Context mContext;
    private List<Weather> mWeatherList;
    private ClickListener mClickListener;

    public WeatherAdapter(Context context, ClickListener clickListener) {
        this.mContext = context;
        this.mClickListener = clickListener;
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
        View view = inflater.inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Weather weather = mWeatherList.get(position);

        /*holder.textViewTemperature.setText(weather.getDayTemperature() + " °C");
        holder.textViewWind.setText(weather.getWindSpeed() + " m/s");
        Glide
                .with(mContext)
                .load("http://openweathermap.org/img/w/" + weather.getIconId() + ".png")
                .into(holder.imageViewWeather);*/

    }

    @Override
    public int getItemCount() {
        if (mWeatherList != null) return mWeatherList.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /*@BindView(R.id.text_view_temperature) protected TextView textViewTemperature;
        @BindView(R.id.text_view_wind) protected TextView textViewWind;
        @BindView(R.id.image_view_weather_image) protected ImageView imageViewWeather;*/

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onClick(mWeatherList.get(getAdapterPosition()));
        }
    }

    public interface ClickListener {

        void onClick(Weather weather);
    }

}
