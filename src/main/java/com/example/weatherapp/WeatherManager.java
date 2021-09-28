package com.example.weatherapp;

import com.example.weatherapp.BOL.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import com.google.gson.*;

public class WeatherManager {
    public String GetForecastString(){
        String ip = LocationManager.GetIP();
        if (!ip.equals("")){
            String lat = LocationManager.GetLat(ip);
            String lon = LocationManager.GetLong(ip);
            String key = CredentialManager.GetApiKey();
            try {
                URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&appid=" + key);
                URLConnection conn = url.openConnection();
                String json;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
                    json = reader.readLine();
                }
                return json;
            } catch (Exception ex){
                ex.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public Forecast GetForecast(){
        Gson gson = new Gson();
        String json = GetForecastString();
        if (!json.equals(""))
            return gson.fromJson(json, Forecast.class);
        else
            return null;
    }
}
