package nl.chefkev.stormy.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import nl.chefkev.stormy.R;
import nl.chefkev.stormy.databinding.ActivityMainBinding;
import nl.chefkev.stormy.weather.Day;
import nl.chefkev.stormy.weather.Forecast;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ImageView iconImageView;
    private Forecast forecast;
    final double latitude = 51.970361;
    final double longitude = 5.650481;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getForecast(latitude, longitude);
        Log.d(TAG, "main UI code is running.");
    }

    //Voorspelling ophalen aan hand van de data van Dark Sky api
    private void getForecast(double latitude, double longitude) {
        final ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this,
                R.layout.activity_main);

        TextView darkSky = findViewById(R.id.darkSkyAttribution);
        darkSky.setMovementMethod(LinkMovementMethod.getInstance());

        iconImageView = findViewById(R.id.iconImageView);

        String apiKey = "ce582382263ad1c4a1ec78f02d7ab0fb";

        String forecastURL = "https://api.darksky.net/forecast/"
                + apiKey + "/" + latitude + "," + longitude + "?units=si&lang=nl";

        if (isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(forecastURL)
                    .build();

            Call call = client.newCall(request);

            call.enqueue(new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                }

                //ophalen van de data adhv JSON
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();

                        if (response.isSuccessful()) {
                            forecast = parseForecastData(jsonData);

                            final CurrentWeather currentWeather = forecast.getCurrent();

                            final CurrentWeather displayWeather = new CurrentWeather(
                                    currentWeather.getLocationLabel(),
                                    currentWeather.getIcon(),
                                    currentWeather.getTime(),
                                    currentWeather.getTemperature(),
                                    currentWeather.getHumidity(),
                                    currentWeather.getPrecipChance(),
                                    currentWeather.getSummary(),
                                    currentWeather.getTimeZone()
                            );

                            binding.setWeather(currentWeather);
                            iconImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), displayWeather.getIconById(), null));

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), currentWeather.getIconById(), null);
                                }
                            });
                        } else {
                            alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "IO Exception caught: ", e);
                    } catch (JSONException e) {
                        Log.e(TAG, "JSON exception caught:", e);
                    }
                }
            });
        }
    }

    //JSON data ophalen en setten
    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);

        String timeZone = forecast.getString("timezone");
        Log.i(TAG, "From JSON: " + timeZone);

        JSONObject currently = forecast.getJSONObject("currently");

        CurrentWeather currentWeather = new CurrentWeather();

        currentWeather.setHumidity(currently.getDouble("humidity"));
        currentWeather.setTime(currently.getLong("time"));
        currentWeather.setIcon(currently.getString("icon"));
        currentWeather.setLocationLabel("");
        currentWeather.setPrecipChance(currently.getDouble("precipProbability"));
        currentWeather.setSummary(currently.getString("summary"));
        currentWeather.setTemperature(currently.getDouble("temperature"));
        currentWeather.setTimeZone(timeZone);
        // loggen van data
        Log.d(TAG, currentWeather.getFormattedTime());

        return currentWeather;
    }

    //checken of het netwerk beschikbaar is, anders toast tonen
    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert manager != null;
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        } else {
            Toast.makeText(this, R.string.network_unavailable_message,
                    Toast.LENGTH_LONG).show();
        }
        return isAvailable;
    }

    //tonen van de alert dialog als er een error is
    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }

    // Instellen van de ververs knop, wordt een toast getoond zodat gebruiker weet dat er iets gebeurd.
    public void refreshOnClick(View view) {
        Toast.makeText(this, "Refreshing data", Toast.LENGTH_LONG).show();
        getForecast(latitude, longitude);
    }

    //maken van het JSON object
    private JSONObject createJSONObject(String JSONData) throws JSONException {
        return new JSONObject(JSONData);
    }

    // Gereed maken van wat er gebeurd als je op de dag knop drukt
    public void dailyOnClick(View view) {
        List<Day> days = Arrays.asList(forecast.getDailyForecast());
        Intent intent = new Intent(this, DailyForecastActivity.class);
        intent.putExtra("dailyList", (Serializable) days);
        startActivity(intent);
    }

    //ophalen van de gegevens uit een JSON array
    private Day[] getDailyForecast(String JSONData) throws JSONException {
        JSONObject forecast = createJSONObject(JSONData);
        String timeZone = forecast.getString("timezone");

        JSONObject daily = forecast.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");

        Day[] days = new Day[data.length()];

        for (int i = 0; i < data.length(); i++) {
            JSONObject jsonDay = data.getJSONObject(i);

            Day day = new Day();

            day.setSummary(jsonDay.getString("summary"));
            day.setTime(jsonDay.getLong("time"));
            day.setIcon(jsonDay.getString("icon"));
            day.setTemperature(jsonDay.getDouble("temperatureMin") + jsonDay.getDouble("temperatureMax") / 2);
            day.setTimezone(timeZone);

            days[i] = day;
        }
        return days;
    }

    //Parsen van de data naar de forecast
    private Forecast parseForecastData(String jsonData) throws JSONException {
        Forecast forecast = new Forecast();

        forecast.setCurrent(getCurrentDetails(jsonData));
        forecast.setDailyForecast(getDailyForecast(jsonData));

        return forecast;
    }
}

