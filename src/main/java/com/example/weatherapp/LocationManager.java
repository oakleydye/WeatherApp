package com.example.weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class LocationManager {
    public static String GetLocation() {
        String location = "";
        String ip = GetIP();
        if (ip.equals("")) {
            return "Location not found";
        }

        location += GetCity(ip);
        location += ", " + GetState(ip);
        location += " " + GetZip(ip);
        return location;
    }

    public static String GetState(String ip) {
        try {
            URL url = new URL("https://ipapi.co/" + ip + "/region");
            URLConnection conn = url.openConnection();
            String location;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                location = reader.readLine();
            }
            return location;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String GetCity(String ip) {
        try {
            URL url = new URL("https://ipapi.co/" + ip + "/city");
            URLConnection conn = url.openConnection();
            String location;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
                location = reader.readLine();
            }
            return location;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String GetZip(String ip) {
        try {
            URL url = new URL("https://ipapi.co/" + ip + "/postal");
            URLConnection conn = url.openConnection();
            String location;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                location = reader.readLine();
            }
            return location;
        } catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public static String GetLat(String ip){
        try{
            URL url = new URL("https://ipapi.co/" + ip + "/latitude");
            URLConnection conn = url.openConnection();
            String location;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
                location = reader.readLine();
            }
            return location;
        } catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public static String GetLong(String ip){
        try{
            URL url = new URL("https://ipapi.co/" + ip + "/longitude");
            URLConnection conn = url.openConnection();
            String location;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
                location = reader.readLine();
            }
            return location;
        } catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public static String GetIP() {
        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String ip = in.readLine();
            in.close();
            return ip;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
