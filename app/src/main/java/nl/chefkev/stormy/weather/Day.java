package nl.chefkev.stormy.weather;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

public class Day implements Serializable {
    private long time;
    private String summary;
    private double temperature;
    private String icon;
    private String timezone;

    public Day() {
    }

    //het ophalen van de juiste tijd
    public String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("hh mm");
        format.setTimeZone(TimeZone.getTimeZone(timezone));

        Date date = new Date(time * 1000);
        return format.format(date);
    }

    //Hier worden getters en setters geplaatst om alle data op te halen en in te stellen
    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getTemperature() {
        return Math.round(temperature);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getIcon() {
        return Forecast.getIconID(icon);
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
