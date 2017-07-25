package networkconnection;

import android.content.Context;

import com.example.leo.weatherintheplace.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Leo on 25.07.2017.
 */

public class JSONFetch {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/forecast?q=%s&mode=json";

    public static JSONObject getJSON(Thread context, String city) {

                try {
//            city = "kiev,ua";
                    URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
                    HttpURLConnection connection =
                            (HttpURLConnection) url.openConnection();

                    connection.addRequestProperty("x-api-key", "9b67ca947d05894c29600bd1f6188a6f");

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

                    StringBuffer json = new StringBuffer(1024);
                    String temp = "";
                    while ((temp = reader.readLine()) != null)
                        json.append(temp).append("\n");
                    reader.close();

                    JSONObject data = new JSONObject(json.toString());

                    // This value will be 404 if the request was not
                    // successful
                    if (data.getInt("cod") != 200) {
                        return null;
                    }
                    connection.disconnect();

                    return data;
                } catch (
                        Exception e)

                {
                    return null;
                }
    }
}
