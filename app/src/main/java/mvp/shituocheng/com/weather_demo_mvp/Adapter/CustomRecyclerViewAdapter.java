package mvp.shituocheng.com.weather_demo_mvp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.R;
import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;

/**
 * Created by shituocheng on 2016/11/1.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WeatherModel> weatherModels = new ArrayList<>();

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }

    public CustomRecyclerViewAdapter(List<WeatherModel> weatherModels) {
        this.weatherModels = weatherModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        ItemViewHolder itemViewHolder = new ItemViewHolder(v);

        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        WeatherModel weatherModel = weatherModels.get(position);

        ((ItemViewHolder)holder).textView.setText(weatherModel.getFengxiang());

    }

    @Override
    public int getItemCount() {
        return weatherModels.size();
    }
}
