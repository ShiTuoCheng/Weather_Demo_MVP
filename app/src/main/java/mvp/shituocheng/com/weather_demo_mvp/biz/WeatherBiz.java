package mvp.shituocheng.com.weather_demo_mvp.biz;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.Utilities.API;
import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;

/**
 * Created by shituocheng on 2016/10/29.
 */

public class WeatherBiz implements IWeatherBiz {

    private List<WeatherModel> weatherModels = new ArrayList<>();


    @Override
    public Runnable fetchData(final OnFetchDataListener onFetchDataListener) {

        return new Runnable() {
            @Override
            public void run() {


                HttpURLConnection connection;
                InputStream inputStream;

                String api = API.getAPI();
                try {
                    connection = (HttpURLConnection) new URL(api).openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    inputStream = connection.getInputStream();
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());

                    JSONObject jObj = jsonObject.getJSONObject("data");

                    JSONArray jsonArray = jObj.getJSONArray("forecast");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject eachObj = jsonArray.getJSONObject(i);

                        WeatherModel.Builder builder = new WeatherModel.Builder();

                        WeatherModel weatherModel = builder
                                .fengli(eachObj.getString("fengli"))
                                .fengxiang(eachObj.getString("fengxiang"))
                                .build();

                        weatherModels.add(weatherModel);

                    }

                    onFetchDataListener.fetchSuccess(weatherModels);

                } catch (IOException e) {
                    e.printStackTrace();
                    onFetchDataListener.fetchFailed();
                } catch (JSONException e) {
                    e.printStackTrace();
                    onFetchDataListener.fetchFailed();
                }
            }
        };
    }
}
