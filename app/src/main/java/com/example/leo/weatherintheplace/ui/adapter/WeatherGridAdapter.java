package com.example.leo.weatherintheplace.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leo.weatherintheplace.R;
import com.example.leo.weatherintheplace.model.WeatherInfo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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


        TextView textView = (TextView) gridItem.findViewById(R.id.text_degrees);
        int temp = (int)mList.get(position).getMain().getTemp() - 273;
        textView.setText(String.valueOf(temp) + " \u00b0");

        ImageView imageView = (ImageView) gridItem.findViewById(R.id.weather_image) ;
        String weather_icon_url = mContext.getString(R.string.icon_url)
                + mList.get(position).getWeather().get(0).getIcon() + ".png";
        new WeatherImageLoadTask(weather_icon_url,imageView).execute();

        return gridItem;
    }

    private class WeatherImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public WeatherImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }

}
