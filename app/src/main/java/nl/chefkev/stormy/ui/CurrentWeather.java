package nl.chefkev.stormy.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import nl.chefkev.stormy.R;
import nl.chefkev.stormy.weather.Forecast;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

public class CurrentWeather {

    private String locationLabel;
    private String icon;
    private long time;
    private double temperature;
    private double humidity;
    private double precipChance;
    private String summary;
    private String timeZone;

    CurrentWeather() {
    }

    //Alle data die nodig is om te kunnen tonen in de MainActivity
    CurrentWeather(String locationLabel, String icon, long time, double temperature,
                   double humidity, double precipChance, String summary, String timeZone) {
        this.locationLabel = locationLabel;
        this.icon = icon;
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipChance = precipChance;
        this.summary = summary;
        this.timeZone = timeZone;
    }

    String getTimeZone() {
        return timeZone;
    }

    void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    String getLocationLabel() {
        return locationLabel;
    }

    void setLocationLabel(String locationLabel) {
        this.locationLabel = locationLabel;
    }

    long getTime() {
        return time;
    }

    //Datum ophalen en zetten in dag-maand & uur-minuut
    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM hh:mm");

        formatter.setTimeZone(TimeZone.getTimeZone(timeZone));

        Date dateTime = new Date(time * 1000);

        return formatter.format(dateTime);
    }

    String getIcon() {
        return icon;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

    int getIconById() {
        return Forecast.getIconID(icon);
    }

    void setTime(long time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipChance() {
        return precipChance;
    }

    void setPrecipChance(double precipChance) {
        this.precipChance = precipChance;
    }

    public String getSummary() {
        return summary;
    }

    void setSummary(String summary) {
        this.summary = summary;
    }
}
