package com.example.weatherapp.BOL;

import java.util.List;

public class ForecastBase {
    public String dt;
    public String pressure;
    public String humidity;
    public String dew_point;
    public String clouds;
    public String uvi;
    public String visibility;
    public String wind_speed;
    public String wind_gust;
    public String wind_deg;
    public Rain rain;
    public Snow snow;
    public List<Weather> weather;
}
