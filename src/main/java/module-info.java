module com.example.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;

    opens com.example.weatherapp to javafx.fxml;
    exports com.example.weatherapp;
    exports com.example.weatherapp.BOL;
    opens com.example.weatherapp.BOL to javafx.fxml;
}