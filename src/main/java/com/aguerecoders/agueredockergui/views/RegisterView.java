package com.aguerecoders.agueredockergui.views;

import com.aguerecoders.agueredockergui.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterView {

    public static Stage registerStage = new Stage();
    private static Stage mainWindow = new Stage();

    public static void show(Stage mainWindow) throws IOException {
        RegisterView.mainWindow = mainWindow;

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        registerStage.setTitle("Hello!");
        registerStage.setScene(scene);
        mainWindow.hide();
        registerStage.show();
    }

    public static void close(){
        mainWindow.show();
        mainWindow.getScene().getRoot().lookupAll(".text-field").forEach(node -> ((TextField) node).setText(""));
        registerStage.close();
    }

}
