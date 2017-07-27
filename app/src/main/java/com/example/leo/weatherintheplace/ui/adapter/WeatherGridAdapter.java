package com.example.leo.weatherintheplace.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leo.weatherintheplace.R;
import com.example.leo.weatherintheplace.model.WeatherInfo;

import java.util.List;

public class WeatherGridAdapter extends BaseAdapter {

    private Context mContext;
    private List<WeatherInfo.WeatherDetails> mList;

    public WeatherGridAdapter(Context c, List<WeatherInfo.WeatherDetails> list) {
        mContext = c;
        mList = list;
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

        int temp = (int)mList.get(position).getMain().getTemp() - 273;
        textView.setText(String.valueOf(temp) + " \u00b0");

        return gridItem;
    }

}
