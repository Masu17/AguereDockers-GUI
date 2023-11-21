package com.aguerecoders.agueredockergui.services;

import com.aguerecoders.agueredockergui.Execption.PersonalException;
import com.aguerecoders.agueredockergui.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class RequestsService {

    public static String getRequest(HttpURLConnection conexion) throws IOException, PersonalException {
        try {
            InputStreamReader inputStreamReader;

            if (checkUser(conexion)) {
                inputStreamReader = new InputStreamReader(conexion.getInputStream());
            } else {
                throw new PersonalException("Usuario no encontrado");
            }

            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuilder content = new StringBuilder();
            String inputLine;


            while ((inputLine = br.readLine()) != null) {
                content.append(inputLine);
            }

            br.close();

            return content.toString();

        } finally {
            conexion.disconnect();
        }
    }

    public static void createUser(UserEntity userEntity, HttpURLConnection conexion) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(userEntity);

            conexion.setRequestProperty("Content-Type", "application/json; utf-8");
            conexion.setRequestProperty("Accept", "application/json");
            conexion.setDoOutput(true);
            conexion.getOutputStream().write(jsonString.getBytes(StandardCharsets.UTF_8));
            conexion.connect();

            System.out.println(conexion.getResponseCode());
        } catch (IOException e) {
            System.out.println("Problema con la lectura de datos");
        } finally {
            conexion.disconnect();
        }
    }

    public static boolean checkUser(HttpURLConnection conexion) throws IOException {
        return conexion.getResponseCode() != 400 && conexion.getResponseCode() != 404 && conexion.getResponseCode() != 500;
    }

}
