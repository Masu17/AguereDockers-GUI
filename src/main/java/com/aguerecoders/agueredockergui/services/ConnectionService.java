package com.aguerecoders.agueredockergui.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionService {

    public static HttpURLConnection openGetConnection(String urlConnection) throws IOException {
        URL url = new URL("http://localhost:8080/api/" + urlConnection);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        return conexion;
    }

    public static HttpURLConnection openPostConnection(String urlConnection) throws IOException {
        URL url = new URL("http://localhost:8080/api/" + urlConnection);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("POST");
        conexion.setDoOutput(true);
        return conexion;
    }

}
