package com.example.leo.weatherintheplace.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.leo.weatherintheplace.R;
import com.example.leo.weatherintheplace.ui.adapter.WeatherGridAdapter;

public class FiveDaysWeather extends AppCompatActivity {

    private String city;
    private String countryCode;
    private double longitude;
    private double latitude;
    private GridView gridview;
    Button showOnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_days_weather);

        Intent intent = getIntent();

        city = intent.getStringExtra(MainActivity.KEY_CITY);
        countryCode = intent.getStringExtra(MainActivity.KEY_COUNTRY_CODE);
        longitude = intent.getDoubleExtra(MainActivity.KEY_LONGITUDE, 0.0);
        latitude = intent.getDoubleExtra(MainActivity.KEY_LATITUDE, 0.0);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new WeatherGridAdapter(this));


    }
}
