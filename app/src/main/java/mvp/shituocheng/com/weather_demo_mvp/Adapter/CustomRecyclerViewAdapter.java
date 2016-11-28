package mvp.shituocheng.com.weather_demo_mvp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvp.shituocheng.com.weather_demo_mvp.R;
import mvp.shituocheng.com.weather_demo_mvp.Utilities.OnRecyclerViewOnClickListener;
import mvp.shituocheng.com.weather_demo_mvp.model.WeatherModel;

/**
 * Created by shituocheng on 2016/11/1.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WeatherModel> weatherModels = new ArrayList<>();

    private OnRecyclerViewOnClickListener onRecyclerViewOnClickListener;

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private OnRecyclerViewOnClickListener onRecyclerViewOnClickListener;

        public ItemViewHolder(View itemView, OnRecyclerViewOnClickListener onRecyclerViewOnClickListener) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text);
            this.onRecyclerViewOnClickListener = onRecyclerViewOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onRecyclerViewOnClickListener != null){
                onRecyclerViewOnClickListener.OnItemClick(view, getLayoutPosition());
            }
        }
    }

    public CustomRecyclerViewAdapter(List<WeatherModel> weatherModels) {
        this.weatherModels = weatherModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        ItemViewHolder itemViewHolder = new ItemViewHolder(v, onRecyclerViewOnClickListener);

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
