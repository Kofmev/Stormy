package nl.chefkev.stormy.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import nl.chefkev.stormy.R;
import nl.chefkev.stormy.weather.Day;
import nl.chefkev.stormy.databinding.DailyListItemBinding;

public class DailyAdapter {

    private List<Day> days;
    private Context context;

    public DailyAdapter(List<Day> days, Context context) {
        this.days = days;
        this.context = context;
    }

    public DailyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        DailyListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.daily_list_item,
                parent, false);

        return new ViewHolder();
    }

    public void onBindViewHolder(DailyAdapter.ViewHolder holder, int position) {
        Day day = days.get(position);
        holder.listItemBinding.setDay(day);
    }

    public int getItemCount() {
        return days.size();
    }

    public class ViewHolder {
        public DailyListItemBinding listItemBinding;
    }
}