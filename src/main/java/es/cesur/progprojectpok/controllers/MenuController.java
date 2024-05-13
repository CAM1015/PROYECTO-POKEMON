package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button btnCentroPokemon;

    @FXML
    private Button btnEntrenamiento;

    @FXML
    private Button btnLogOut;


    @FXML
    protected void onCombateBtnClick() {
        try {
            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/combate-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("Combate");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnCombate.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onEquipoBtnClick() {
        try {
            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/equipo-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("Equipo");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnEquipo.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onEntrenamientoBtnClick() {
        try {
            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/entrenamiento-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("Entrenamiento");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnEntrenamiento.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onCapturaBtnClick() {
        try {
            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/captura-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("Captura");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnCaptura.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onCentroPokemonBtnClick() {
        try {
            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/centropokemon-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("CentroPokemon");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnCentroPokemon.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onCrianzaBtnClick() {
        try {
            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/crianza-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("Crianza");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnCrianza.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onLogOutBtnClick() {
        try {

            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/login-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 736, 746);
            Newstage.setTitle("LogIn");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnLogOut.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }



}
