package nl.chefkev.stormy.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ContentDailyForecastBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView dailyListItems;

  protected ContentDailyForecastBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView dailyListItems) {
    super(_bindingComponent, _root, _localFieldCount);
    this.dailyListItems = dailyListItems;
  }

  @NonNull
  public static ContentDailyForecastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentDailyForecastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentDailyForecastBinding>inflate(inflater, nl.chefkev.stormy.R.layout.content_daily_forecast, root, attachToRoot, component);
  }

  @NonNull
  public static ContentDailyForecastBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentDailyForecastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentDailyForecastBinding>inflate(inflater, nl.chefkev.stormy.R.layout.content_daily_forecast, null, false, component);
  }

  public static ContentDailyForecastBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentDailyForecastBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentDailyForecastBinding)bind(component, view, nl.chefkev.stormy.R.layout.content_daily_forecast);
  }
}
