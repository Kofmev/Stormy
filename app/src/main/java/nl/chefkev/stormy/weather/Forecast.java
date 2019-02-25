package nl.chefkev.stormy.weather;

import nl.chefkev.stormy.R;
import nl.chefkev.stormy.ui.CurrentWeather;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

public class Forecast {
    private CurrentWeather current;
    private Day[] dailyForecast;

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public Day[] getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(Day[] dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    //Hier worden de icons in een switch gezet en aan de hand van de door de API verstrekte data wordt de goede getoond.
    public static int getIconID(String icon) {
        int iconID = R.drawable.clear_day;

        switch (icon) {
            case "rain":
                iconID = R.drawable.rain;
                break;
            case "snow":
                iconID = R.drawable.snow;
                break;
            case "sleet":
                iconID = R.drawable.sleet;
                break;
            case "wind":
                iconID = R.drawable.wind;
                break;
            case "fog":
                iconID = R.drawable.fog;
                break;
            case "cloudy":
                iconID = R.drawable.cloudy;
                break;
            case "partly-cloudy-day":
                iconID = R.drawable.partly_cloudy;
                break;
            case "partly-cloudy-night":
                iconID = R.drawable.cloudy_night;
                break;
        }
        return iconID;
    }
}