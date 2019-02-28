package nl.chefkev.stormy.databinding;
import nl.chefkev.stormy.R;
import nl.chefkev.stormy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.degreeImageView, 6);
        sViewsWithIds.put(R.id.locationValue, 7);
        sViewsWithIds.put(R.id.iconImageView, 8);
        sViewsWithIds.put(R.id.guideline, 9);
        sViewsWithIds.put(R.id.guideline2, 10);
        sViewsWithIds.put(R.id.humidityLabel, 11);
        sViewsWithIds.put(R.id.precipLabel, 12);
        sViewsWithIds.put(R.id.darkSkyAttribution, 13);
        sViewsWithIds.put(R.id.dailyForecastButton, 14);
        sViewsWithIds.put(R.id.refreshImageView, 15);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.ImageView) bindings[6]
            , (android.support.constraint.Guideline) bindings[9]
            , (android.support.constraint.Guideline) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.humidityValue.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.precipValue.setTag(null);
        this.summaryValue.setTag(null);
        this.temperatureValue.setTag(null);
        this.timeValue.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.weather == variableId) {
            setWeather((nl.chefkev.stormy.ui.CurrentWeather) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setWeather(@Nullable nl.chefkev.stormy.ui.CurrentWeather Weather) {
        this.mWeather = Weather;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.weather);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String stringValueOfWeatherFormattedTimeJavaLangStringIsHet = null;
        java.lang.String weatherFormattedTime = null;
        double weatherHumidity = 0.0;
        nl.chefkev.stormy.ui.CurrentWeather weather = mWeather;
        long mathRoundWeatherPrecipChanceInt100 = 0L;
        java.lang.String javaLangStringOpStringValueOfWeatherFormattedTimeJavaLangStringIsHet = null;
        double weatherTemperature = 0.0;
        java.lang.String stringValueOfMathRoundWeatherPrecipChanceInt100 = null;
        java.lang.String stringValueOfMathRoundWeatherTemperature = null;
        double weatherPrecipChance = 0.0;
        long mathRoundWeatherTemperature = 0L;
        java.lang.String stringValueOfWeatherHumidity = null;
        java.lang.String stringValueOfMathRoundWeatherPrecipChanceInt100JavaLangString = null;
        java.lang.String weatherSummary = null;
        java.lang.String weatherFormattedTimeJavaLangStringIsHet = null;
        double weatherPrecipChanceInt100 = 0.0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (weather != null) {
                    // read weather.formattedTime
                    weatherFormattedTime = weather.getFormattedTime();
                    // read weather.humidity
                    weatherHumidity = weather.getHumidity();
                    // read weather.temperature
                    weatherTemperature = weather.getTemperature();
                    // read weather.precipChance
                    weatherPrecipChance = weather.getPrecipChance();
                    // read weather.summary
                    weatherSummary = weather.getSummary();
                }


                // read (weather.formattedTime) + (" is het")
                weatherFormattedTimeJavaLangStringIsHet = (weatherFormattedTime) + (" is het");
                // read String.valueOf(weather.humidity)
                stringValueOfWeatherHumidity = java.lang.String.valueOf(weatherHumidity);
                // read Math.round(weather.temperature)
                mathRoundWeatherTemperature = java.lang.Math.round(weatherTemperature);
                // read (weather.precipChance) * (100)
                weatherPrecipChanceInt100 = (weatherPrecipChance) * (100);


                // read String.valueOf((weather.formattedTime) + (" is het"))
                stringValueOfWeatherFormattedTimeJavaLangStringIsHet = java.lang.String.valueOf(weatherFormattedTimeJavaLangStringIsHet);
                // read String.valueOf(Math.round(weather.temperature))
                stringValueOfMathRoundWeatherTemperature = java.lang.String.valueOf(mathRoundWeatherTemperature);
                // read Math.round((weather.precipChance) * (100))
                mathRoundWeatherPrecipChanceInt100 = java.lang.Math.round(weatherPrecipChanceInt100);


                // read ("Op ") + (String.valueOf((weather.formattedTime) + (" is het")))
                javaLangStringOpStringValueOfWeatherFormattedTimeJavaLangStringIsHet = ("Op ") + (stringValueOfWeatherFormattedTimeJavaLangStringIsHet);
                // read String.valueOf(Math.round((weather.precipChance) * (100)))
                stringValueOfMathRoundWeatherPrecipChanceInt100 = java.lang.String.valueOf(mathRoundWeatherPrecipChanceInt100);


                // read (String.valueOf(Math.round((weather.precipChance) * (100)))) + (" % ")
                stringValueOfMathRoundWeatherPrecipChanceInt100JavaLangString = (stringValueOfMathRoundWeatherPrecipChanceInt100) + (" % ");
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.humidityValue, stringValueOfWeatherHumidity);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.precipValue, stringValueOfMathRoundWeatherPrecipChanceInt100JavaLangString);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.summaryValue, weatherSummary);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.temperatureValue, stringValueOfMathRoundWeatherTemperature);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.timeValue, javaLangStringOpStringValueOfWeatherFormattedTimeJavaLangStringIsHet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): weather
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}