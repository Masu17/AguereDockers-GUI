package com.aguerecoders.agueredockergui.controllers;

import com.aguerecoders.agueredockergui.entity.UserEntity;
import com.aguerecoders.agueredockergui.services.ConnectionService;
import com.aguerecoders.agueredockergui.services.DesingService;
import com.aguerecoders.agueredockergui.services.RequestsService;
import com.aguerecoders.agueredockergui.views.RegisterView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class RegisterController {

    public TextField emailTextField1;
    public TextField userNameTextField;
    public TextField pwTextField;
    public ImageView waveImage;
    public Label returnLogIn;

    @FXML
    public void initialize() {
        DesingService.imageSetter(waveImage);
    }

    public void registerActionBttn() throws IOException {
        String email = emailTextField1.getText();
        String userName = userNameTextField.getText();
        String pw = pwTextField.getText();

        if (email.isEmpty() || userName.isEmpty() || pw.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("No pueden haber campos vacios");
            alert.showAndWait();
            return;
        }

        if (!RequestsService.checkUser(ConnectionService
                .openGetConnection("user/username/" + userNameTextField.getText()))) {
            RequestsService.createUser(new UserEntity(
                            userNameTextField.getText(),
                            emailTextField1.getText(),
                            pwTextField.getText()),
                    ConnectionService.openPostConnection("user"
                    ));

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El usuario ya existe");
            alert.showAndWait();
            return;
        }

        if (RequestsService.checkUser(ConnectionService
                .openGetConnection("user/username/" + userNameTextField.getText()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro");
            alert.setHeaderText("Registro correcto");
            alert.setContentText("Usuario registrado correctamente");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Hubo un problema al registrar el usuario");
            alert.showAndWait();
        }

    }

    public void returnMainMenu() {
        RegisterView.close();
    }
}
