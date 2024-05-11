package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */

    @FXML
    private Button btnEquipo;

    @FXML
    private Button btnCombate;

    @FXML
    private Button btnCaptura;

    @FXML
    private Button btnCrianza;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnCentroPokemon;

    @FXML
    private Button btnEntrenamiento;





    @FXML
    protected void onLogOutClick() {
        try {

            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("es/cesur/progprojectpok/view/login-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 736, 746);
            Newstage.setTitle("LogIn");
            Newstage.setScene(scene);
            Newstage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cargar datos del usuario si seleccionó el remember me


    }



}
