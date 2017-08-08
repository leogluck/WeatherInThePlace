package com.example.leo.weatherintheplace.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.leo.weatherintheplace.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CityOnMap extends FragmentActivity
        implements OnMapReadyCallback {

    private double longitude;
    private double latitude;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_on_map);

        Intent intent = getIntent();
        city = intent.getStringExtra(MainActivity.KEY_CITY);
        longitude = intent.getDoubleExtra(MainActivity.KEY_LONGITUDE, 0.0);
        latitude = intent.getDoubleExtra(MainActivity.KEY_LATITUDE, 0.0);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(CityOnMap.this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        LatLng location = new LatLng(latitude,longitude);
        map.addMarker(new MarkerOptions().position(location).title("Marker in " + city + " city"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
    }
}
