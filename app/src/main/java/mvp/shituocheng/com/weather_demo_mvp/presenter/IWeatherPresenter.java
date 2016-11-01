package mvp.shituocheng.com.weather_demo_mvp.presenter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mvp.shituocheng.com.weather_demo_mvp.biz.IWeatherBiz;
import mvp.shituocheng.com.weather_demo_mvp.biz.OnFetchDataListener;
import mvp.shituocheng.com.weather_demo_mvp.biz.WeatherBiz;
import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;
import mvp.shituocheng.com.weather_demo_mvp.view.IWeatherView;

/**
 * Created by shituocheng on 2016/10/31.
 */

public class IWeatherPresenter {

    private IWeatherBiz iWeatherBiz;
    private IWeatherView iWeatherView;

    private ExecutorService threadPool = Executors.newCachedThreadPool();


    public IWeatherPresenter(IWeatherView iWeatherView) {
        this.iWeatherBiz = new WeatherBiz();
        this.iWeatherView = iWeatherView;
    }

    public void fetchData(){

        threadPool.execute(iWeatherBiz.fetchData(new OnFetchDataListener() {
            @Override
            public void fetchSuccess(List<WeatherModel> weatherModels) {
                iWeatherView.toMainActivity(weatherModels);
            }

            @Override
            public void fetchFailed() {

                iWeatherView.showFailError();
            }
        }));
    }

}
