package com.example.leo.weatherintheplace.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherAPI {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
