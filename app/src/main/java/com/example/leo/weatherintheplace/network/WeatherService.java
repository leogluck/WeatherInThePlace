package com.example.leo.weatherintheplace.network;

import com.example.leo.weatherintheplace.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherService {
    @GET("forecast")
    Call<WeatherInfo> getWeather(@Query("q") String cityAndCountryCode, @Query("appid") String apiKey);
}