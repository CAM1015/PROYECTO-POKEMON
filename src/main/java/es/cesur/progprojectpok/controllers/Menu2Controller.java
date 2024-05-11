package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu2Controller {
    @FXML
    private PasswordField passField;

    @FXML
    private TextField txtFieldName;

    @FXML
    void onActionBtnLogin(ActionEvent event) throws IOException {
        System.out.println("Botón pulsado.");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/hello-view2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 827);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();


    }

}
