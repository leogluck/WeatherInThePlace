package com.example.leo.weatherintheplace.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.GridView;

import com.example.leo.weatherintheplace.R;
import com.example.leo.weatherintheplace.model.WeatherInfo;
import com.example.leo.weatherintheplace.network.WeatherAPI;
import com.example.leo.weatherintheplace.network.WeatherService;
import com.example.leo.weatherintheplace.ui.adapter.WeatherGridAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FiveDaysWeather extends AppCompatActivity {

    private String city;
    private String countryCode;
    private String cityAndCountryCode;
    private double longitude;
    private double latitude;
    private Button showOnMap;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_days_weather);
        gridview = (GridView) findViewById(R.id.gridview);

        Intent intent = getIntent();

        city = intent.getStringExtra(MainActivity.KEY_CITY);
        countryCode = intent.getStringExtra(MainActivity.KEY_COUNTRY_CODE);
        longitude = intent.getDoubleExtra(MainActivity.KEY_LONGITUDE, 0.0);
        latitude = intent.getDoubleExtra(MainActivity.KEY_LATITUDE, 0.0);
        cityAndCountryCode = city + "," + countryCode;


        WeatherService weatherService =
                WeatherAPI.getClient().create(WeatherService.class);

        Call<WeatherInfo> call = weatherService.getWeather(cityAndCountryCode, getString(R.string.weather_api_key));
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                List<WeatherInfo.WeatherDetails> weatherDetailsList = response.body().getList();

                gridview.setAdapter(new WeatherGridAdapter(FiveDaysWeather.this, weatherDetailsList));
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {

            }
        });


    }
}
