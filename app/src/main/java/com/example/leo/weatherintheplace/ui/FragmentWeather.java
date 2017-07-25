package com.example.leo.weatherintheplace.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leo.weatherintheplace.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWeather extends Fragment {

    TextView cityField;
    TextView currentTemperatureField;
    TextView weatherIcon;

    public FragmentWeather() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_weather, container, false);
        cityField = (TextView)rootView.findViewById(R.id.city_field);
        currentTemperatureField = (TextView)rootView.findViewById(R.id.current_temperature_field);
        weatherIcon = (TextView)rootView.findViewById(R.id.weather_icon);

        return rootView;
    }

}
