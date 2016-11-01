package mvp.shituocheng.com.weather_demo_mvp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.R;
import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;
import mvp.shituocheng.com.weather_demo_mvp.presenter.IWeatherPresenter;
import mvp.shituocheng.com.weather_demo_mvp.view.IWeatherView;

public class MainActivity extends AppCompatActivity implements IWeatherView {

    private IWeatherPresenter iWeatherPresenter = new IWeatherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iWeatherPresenter.fetchData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void toMainActivity(List<WeatherModel> weatherModels) {

        WeatherModel weatherModel = weatherModels.get(0);
        Log.d("fengli", weatherModel.getFengli());
    }

    @Override
    public void showFailError() {

    }
}
