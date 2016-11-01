package mvp.shituocheng.com.weather_demo_mvp.biz;

/**
 * Created by shituocheng on 2016/10/29.
 */

public interface IWeatherBiz {

     Runnable fetchData(OnFetchDataListener onFetchDataListener);
}
