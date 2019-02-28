package nl.chefkev.stormy;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nl.chefkev.stormy.databinding.ActivityMainBindingImpl;
import nl.chefkev.stormy.databinding.ContentDailyForecastBindingImpl;
import nl.chefkev.stormy.databinding.DailyListItemBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_CONTENTDAILYFORECAST = 2;

  private static final int LAYOUT_DAILYLISTITEM = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(nl.chefkev.stormy.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(nl.chefkev.stormy.R.layout.content_daily_forecast, LAYOUT_CONTENTDAILYFORECAST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(nl.chefkev.stormy.R.layout.daily_list_item, LAYOUT_DAILYLISTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTDAILYFORECAST: {
          if ("layout/content_daily_forecast_0".equals(tag)) {
            return new ContentDailyForecastBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_daily_forecast is invalid. Received: " + tag);
        }
        case  LAYOUT_DAILYLISTITEM: {
          if ("layout/daily_list_item_0".equals(tag)) {
            return new DailyListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for daily_list_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "weather");
      sKeys.put(2, "day");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_main_0", nl.chefkev.stormy.R.layout.activity_main);
      sKeys.put("layout/content_daily_forecast_0", nl.chefkev.stormy.R.layout.content_daily_forecast);
      sKeys.put("layout/daily_list_item_0", nl.chefkev.stormy.R.layout.daily_list_item);
    }
  }
}
