package mvp.shituocheng.com.weather_demo_mvp.Activity;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.Adapter.CustomRecyclerViewAdapter;
import mvp.shituocheng.com.weather_demo_mvp.R;
import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;
import mvp.shituocheng.com.weather_demo_mvp.presenter.IWeatherPresenter;
import mvp.shituocheng.com.weather_demo_mvp.view.IWeatherView;

public class MainActivity extends AppCompatActivity implements IWeatherView {

    private IWeatherPresenter iWeatherPresenter = new IWeatherPresenter(this);
    private CustomRecyclerViewAdapter customRecyclerViewAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        iWeatherPresenter.fetchData();
    }

    @Override
    public void initView() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

    }

    @Override
    public void toMainActivity(final List<WeatherModel> weatherModels) {

        WeatherModel weatherModel = weatherModels.get(1);
        Log.d("test", weatherModel.getFengli());
        Log.d("thread", Thread.currentThread().getName());
        Log.d("size", String.valueOf(weatherModels.size()));

        uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable() {
            @Override
            public void run() {

                customRecyclerViewAdapter = new CustomRecyclerViewAdapter(weatherModels);
                linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(customRecyclerViewAdapter);
            }
        });

    }

    @Override
    public void showFailError() {

    }
}
