package com.alexredchets.sunshineweather.mvp.main;

public class WeatherPresenter {
/*

    private static final String TAG = WeatherPresenter.class.getSimpleName();
    private Retrofit retrofit;
    private WeatherInterface.WeatherActivityInterface view;

    @Inject protected WeatherMapper mWeatherMapper;

    @Inject
    public WeatherPresenter(Retrofit retrofit, WeatherInterface.WeatherFragmentInterface view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void fetchData() {
        Log.i(TAG, "fetchData started");

        retrofit.create(WeatherApi.class).getWeather("52.051503",
                "113.471191",
                5 ,
                "metric",
                "d73975775ce9c90c9b05799d119ef5e9")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.e(TAG, "Successfully got data");

                            List<Weather> weatherList = mWeatherMapper.mapWeather(response);
                            view.onComplete(weatherList);
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());

                            view.onError(throwable.getMessage());
                        });
    }

    @Override
    public void fetchDataDB() {

    }
*/
}
