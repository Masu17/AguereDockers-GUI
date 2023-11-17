module com.aguerecoders.agueredockergui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aguerecoders.agueredockergui to javafx.fxml;
    exports com.aguerecoders.agueredockergui;
}