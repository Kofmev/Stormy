package nl.chefkev.stormy.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import nl.chefkev.stormy.R;
import nl.chefkev.stormy.weather.Day;
import nl.chefkev.stormy.databinding.DailyListItemBinding;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

//Hier wordt de data klaargezet om in het overzicht Per dag te tonen.

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {

    private List<Day> days;
    private Context context;

    public DailyAdapter(List<Day> days, Context context) {
        this.days = days;
        this.context = context;
    }

    //Gebruik maken van een recyclerView
    @Override
    public DailyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        DailyListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.daily_list_item,
                parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DailyAdapter.ViewHolder holder, int position) {
        Day day = days.get(position);
        holder.listItemBinding.setDay(day);
    }

    //het aantal items dat getoond moet worden
    @Override
    public int getItemCount() {
        return days.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        DailyListItemBinding listItemBinding;

        ViewHolder(DailyListItemBinding dailyLayoutItemBinding) {
            super(dailyLayoutItemBinding.getRoot());
            listItemBinding = dailyLayoutItemBinding;
        }


    }
}