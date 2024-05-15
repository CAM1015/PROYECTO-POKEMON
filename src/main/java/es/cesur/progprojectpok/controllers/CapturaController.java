package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CapturaController implements Initializable {



    @FXML
    private Button btnVolver;

    @FXML
    private Button btnCapturar;

    @FXML
    private Button btnGenerarPokemonAleatorio;

    @FXML
    private Label lblCapturaResultado;

    @FXML
    private Label lblNombrePokemonSalvaje;



    @FXML
    protected void onVolverBtnClick() {
        try {

            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/menu-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 751, 475);
            Newstage.setTitle("Menu");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnVolver.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onCapturarClick(ActionEvent actionEvent) {
    }

    public void onMenuPrincipalClick(ActionEvent actionEvent) {
    }

    public void onGenerarPokemonAleatorioClick(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}