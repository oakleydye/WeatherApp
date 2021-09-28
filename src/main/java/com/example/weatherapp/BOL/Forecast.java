package com.example.weatherapp.BOL;

import java.util.List;

public class Forecast {
    public String lat;
    public String lon;
    public String timezone;
    public String timezone_offset;
    public CurrentForecast current;
    public List<MinuteForecast> minutely;
    public List<HourlyForecast> hourly;
    public List<DailyForecast> daily;
    public List<Alert> alerts;
}
