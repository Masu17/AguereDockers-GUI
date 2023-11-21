package com.aguerecoders.agueredockergui.services;

import com.aguerecoders.agueredockergui.Execption.PersonalException;
import javafx.scene.control.Alert;
import org.json.JSONException;

import java.io.IOException;

public class LoginService {

    public static void loginCheckOut(String userNameTextField, String userPWTextField) throws IOException, JSONException, PersonalException {

        if (JSONService
                .JSONValueRetrival(retriveUserData(userNameTextField))
                .getName()
                .equals(userNameTextField) &&
                JSONService
                        .JSONValueRetrival(retriveUserData(userNameTextField)).
                        getPassword()
                        .equals(userPWTextField)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText("Login correcto");
            alert.setContentText("Bienvenido " + userNameTextField);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el login");
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }

    }

    private static String retriveUserData(String userNameTextField) throws IOException, PersonalException {
        return RequestsService.getRequest(ConnectionService.openGetConnection("user/username/" + userNameTextField));
    }

}
