package mvp.shituocheng.com.weather_demo_mvp.view;

import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;

/**
 * Created by shituocheng on 2016/10/31.
 */

public interface IWeatherView {

    void initView();

    void toMainActivity(List<WeatherModel> weatherModels);

    void showFailError();
}
