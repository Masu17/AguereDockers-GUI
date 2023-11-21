package com.aguerecoders.agueredockergui.controllers;

import com.aguerecoders.agueredockergui.Execption.PersonalException;
import com.aguerecoders.agueredockergui.services.*;
import com.aguerecoders.agueredockergui.views.RegisterView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONException;

import java.io.IOException;

public class MainController {

    @FXML
    public ImageView waveImage;
    @FXML
    public TextField userNameTextField;
    @FXML
    public TextField pwTextField;

    @FXML
    public void initialize() {
        DesingService.imageSetter(waveImage);
    }
    @FXML
    public void loginActionBttn() {
        try {
            System.out.println("Login button pressed");
            LoginService.loginCheckOut(userNameTextField.getText(), pwTextField.getText());
        } catch (JSONException e) {
            System.out.println("Problema al cargar el JSON");
        } catch (IOException e) {
            System.out.println("Problema en la solicitud GET");
        } catch (PersonalException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de login");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void openRegisterMenu() {
        try {
            RegisterView.show((Stage) waveImage.getScene().getWindow());
        } catch (IOException e) {
            System.out.println("Problema al cargar el FXML");
        }
    }
}