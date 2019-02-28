package nl.chefkev.stormy.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import nl.chefkev.stormy.weather.Day;

public abstract class DailyListItemBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout dailyListView;

  @NonNull
  public final TextView dayLabel;

  @NonNull
  public final ImageView degreeSmallView;

  @NonNull
  public final ImageView iconImageView;

  @NonNull
  public final TextView summaryLabel;

  @NonNull
  public final TextView temperatureLabel;

  @Bindable
  protected Day mDay;

  protected DailyListItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout dailyListView, TextView dayLabel,
      ImageView degreeSmallView, ImageView iconImageView, TextView summaryLabel,
      TextView temperatureLabel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.dailyListView = dailyListView;
    this.dayLabel = dayLabel;
    this.degreeSmallView = degreeSmallView;
    this.iconImageView = iconImageView;
    this.summaryLabel = summaryLabel;
    this.temperatureLabel = temperatureLabel;
  }

  public abstract void setDay(@Nullable Day day);

  @Nullable
  public Day getDay() {
    return mDay;
  }

  @NonNull
  public static DailyListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DailyListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DailyListItemBinding>inflate(inflater, nl.chefkev.stormy.R.layout.daily_list_item, root, attachToRoot, component);
  }

  @NonNull
  public static DailyListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DailyListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DailyListItemBinding>inflate(inflater, nl.chefkev.stormy.R.layout.daily_list_item, null, false, component);
  }

  public static DailyListItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DailyListItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DailyListItemBinding)bind(component, view, nl.chefkev.stormy.R.layout.daily_list_item);
  }
}
