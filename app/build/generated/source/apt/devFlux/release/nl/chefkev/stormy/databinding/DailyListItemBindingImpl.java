package nl.chefkev.stormy.databinding;
import nl.chefkev.stormy.R;
import nl.chefkev.stormy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DailyListItemBindingImpl extends DailyListItemBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DailyListItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private DailyListItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            );
        this.dailyListView.setTag(null);
        this.dayLabel.setTag(null);
        this.iconImageView.setTag(null);
        this.summaryLabel.setTag(null);
        this.temperatureLabel.setTag(null);
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
        if (BR.day == variableId) {
            setDay((nl.chefkev.stormy.weather.Day) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDay(@Nullable nl.chefkev.stormy.weather.Day Day) {
        this.mDay = Day;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.day);
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
        java.lang.String stringValueOfDaySummary = null;
        java.lang.String stringValueOfDayTime = null;
        java.lang.String stringValueOfDayTemperature = null;
        java.lang.String daySummary = null;
        double dayTemperature = 0.0;
        int dayIcon = 0;
        java.lang.String dayTime = null;
        nl.chefkev.stormy.weather.Day day = mDay;

        if ((dirtyFlags & 0x3L) != 0) {



                if (day != null) {
                    // read day.summary
                    daySummary = day.getSummary();
                    // read day.temperature
                    dayTemperature = day.getTemperature();
                    // read day.icon
                    dayIcon = day.getIcon();
                    // read day.time
                    dayTime = day.getTime();
                }


                // read String.valueOf(day.summary)
                stringValueOfDaySummary = java.lang.String.valueOf(daySummary);
                // read String.valueOf(day.temperature)
                stringValueOfDayTemperature = java.lang.String.valueOf(dayTemperature);
                // read String.valueOf(day.time)
                stringValueOfDayTime = java.lang.String.valueOf(dayTime);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.dayLabel, stringValueOfDayTime);
            this.iconImageView.setImageResource(dayIcon);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.summaryLabel, stringValueOfDaySummary);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.temperatureLabel, stringValueOfDayTemperature);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): day
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}