package com.example.leo.weatherintheplace.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leo.weatherintheplace.R;

public class WeatherGridAdapter extends BaseAdapter {

    private Context mContext;

    public WeatherGridAdapter(Context c) {
        mContext = c;
    }


    @Override
    public int getCount() {
        return 15;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridItem = layoutInflater.inflate(R.layout.weather_item_view, parent, false);
        } else {
            gridItem = convertView;
        }

        ImageView imageView = (ImageView) gridItem.findViewById(R.id.weather_image) ;
        TextView textView = (TextView) gridItem.findViewById(R.id.text_degrees);
        imageView.setImageResource(R.mipmap.ic_launcher);
        textView.setText("26" + "\u00b0");

        return gridItem;
    }

}
