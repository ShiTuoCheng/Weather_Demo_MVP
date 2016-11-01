package mvp.shituocheng.com.weather_demo_mvp.biz;

import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;

/**
 * Created by shituocheng on 2016/10/29.
 */

public interface OnFetchDataListener {

    void fetchSuccess(List<WeatherModel> weatherModels);

    void fetchFailed();
}
