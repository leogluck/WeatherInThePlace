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
import com.squareup.picasso.Picasso;

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
        return 24;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridItem = layoutInflater.inflate(R.layout.weather_item_view, parent, false);
        } else {
            gridItem = convertView;
        }

        TextView textView = (TextView) gridItem.findViewById(R.id.text_degrees);
        int temp = (int)mList.get(position).getMain().getTemp() - 273;
        textView.setText(String.valueOf(temp) + " \u00b0");

        ImageView imageView = (ImageView) gridItem.findViewById(R.id.weather_image) ;
        String weather_icon_url = mContext.getString(R.string.icon_url)
                + mList.get(position).getWeather().get(0).getIcon() + ".png";
        Picasso.with(mContext).load(weather_icon_url).into(imageView);

        return gridItem;
    }
}
