package com.example.weatherapp;

import com.example.weatherapp.BOL.Forecast;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class HelloController {
    @FXML private Label welcomeText;
    @FXML private TabPane tabPane1;
    @FXML private Tab tbSummary;
    @FXML private Tab tbCurrentDayForecast;

    @FXML
    protected void onHelloButtonClick() {
        String location = LocationManager.GetLocation();
        welcomeText.setText("Welcome to the weather app! Your location is: " + location);
        Tab tab = new Tab("Tab from button");
        tabPane1.getTabs().add(tab);

        WeatherManager manager = new WeatherManager();
        try{
            Forecast forecast = manager.GetForecast();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}