package nl.chefkev.stormy.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import nl.chefkev.stormy.ui.CurrentWeather;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final Button dailyForecastButton;

  @NonNull
  public final TextView darkSkyAttribution;

  @NonNull
  public final ImageView degreeImageView;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final TextView humidityLabel;

  @NonNull
  public final TextView humidityValue;

  @NonNull
  public final ImageView iconImageView;

  @NonNull
  public final TextView locationValue;

  @NonNull
  public final TextView precipLabel;

  @NonNull
  public final TextView precipValue;

  @NonNull
  public final ImageView refreshImageView;

  @NonNull
  public final TextView summaryValue;

  @NonNull
  public final TextView temperatureValue;

  @NonNull
  public final TextView timeValue;

  @Bindable
  protected CurrentWeather mWeather;

  protected ActivityMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button dailyForecastButton, TextView darkSkyAttribution,
      ImageView degreeImageView, Guideline guideline, Guideline guideline2, TextView humidityLabel,
      TextView humidityValue, ImageView iconImageView, TextView locationValue, TextView precipLabel,
      TextView precipValue, ImageView refreshImageView, TextView summaryValue,
      TextView temperatureValue, TextView timeValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.dailyForecastButton = dailyForecastButton;
    this.darkSkyAttribution = darkSkyAttribution;
    this.degreeImageView = degreeImageView;
    this.guideline = guideline;
    this.guideline2 = guideline2;
    this.humidityLabel = humidityLabel;
    this.humidityValue = humidityValue;
    this.iconImageView = iconImageView;
    this.locationValue = locationValue;
    this.precipLabel = precipLabel;
    this.precipValue = precipValue;
    this.refreshImageView = refreshImageView;
    this.summaryValue = summaryValue;
    this.temperatureValue = temperatureValue;
    this.timeValue = timeValue;
  }

  public abstract void setWeather(@Nullable CurrentWeather weather);

  @Nullable
  public CurrentWeather getWeather() {
    return mWeather;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, nl.chefkev.stormy.R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, nl.chefkev.stormy.R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMainBinding)bind(component, view, nl.chefkev.stormy.R.layout.activity_main);
  }
}
