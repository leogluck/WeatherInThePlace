package com.example.leo.weatherintheplace.model;

import java.util.List;

public class WeatherInfo {
    private List<WeatherDetails> list;

    public class Main {
        private double temp;

        public double getTemp() {
            return temp;
        }
    }

    public class Weather {
        private String icon;

        public String getIcon() {
            return icon;
        }
    }

    public class WeatherDetails{
        private Main main;
        private List<Weather> weather;

        public Main getMain() {
            return main;
        }

        public List<Weather> getWeather() {
            return weather;
        }
    }

    public List<WeatherDetails> getList() {
        return list;
    }
}
