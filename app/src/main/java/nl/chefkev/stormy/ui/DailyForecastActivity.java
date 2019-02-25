package nl.chefkev.stormy.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import nl.chefkev.stormy.R;
import nl.chefkev.stormy.adapter.DailyAdapter;
import nl.chefkev.stormy.databinding.ContentDailyForecastBinding;
import nl.chefkev.stormy.weather.Day;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

public class DailyForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_daily_forecast);
        List<Day> dayList = (ArrayList<Day>) intent.getSerializableExtra("dailyList");
        ContentDailyForecastBinding binding = DataBindingUtil.setContentView(this, R.layout.content_daily_forecast);
        DailyAdapter dailyAdapter = new DailyAdapter(dayList, this);

        binding.dailyListItems.setAdapter(dailyAdapter);
        binding.dailyListItems.setLayoutManager(new LinearLayoutManager(this));
    }
}
