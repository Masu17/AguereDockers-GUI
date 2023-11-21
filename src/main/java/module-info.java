module com.aguerecoders.agueredockergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires android.json;
    requires lombok;
    requires com.fasterxml.jackson.databind;

    opens com.aguerecoders.agueredockergui to javafx.fxml;
    exports com.aguerecoders.agueredockergui;
    opens com.aguerecoders.agueredockergui.controllers to javafx.fxml;
    opens com.aguerecoders.agueredockergui.entity to com.fasterxml.jackson.databind;
}