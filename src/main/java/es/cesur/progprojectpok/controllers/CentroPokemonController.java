package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.model.Entrenador;
import es.cesur.progprojectpok.model.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CentroPokemonController implements Initializable {

    @FXML
    private TableView<Pokemon> pokemonTableView;

    @FXML
    private TableColumn<Pokemon, ImageView> imageColumn;

    @FXML
    private TableColumn<Pokemon, String> moteColumn;

    @FXML
    private TableColumn<Pokemon, Integer> vitalidadColumn;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnCurar;

    private Entrenador entrenador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mostrarEquipoYVitalidad();
    }


    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
        mostrarEquipoYVitalidad();
    }



    private void mostrarEquipoYVitalidad() {
        if (entrenador != null) {
            pokemonTableView.setItems(entrenador.getEquipoPrincipal());
            vitalidadColumn.setCellValueFactory(cellData -> cellData.getValue().vitalidadProperty().asObject());
        }
    }


    public void onCurarBtnClick(ActionEvent actionEvent) {
        if (entrenador != null) {
            for (Pokemon pokemon : entrenador.getEquipoPrincipal()) {
                pokemon.setVitalidad(100); // Asumo que el máximo de vitalidad es 100
            }
            mostrarEquipoYVitalidad();
        }
    }

    public void onVolverBtnClick(ActionEvent actionEvent) {
        try {

            Stage Newstage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/menu-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(), 475, 751);
            Newstage.setTitle("Menu");
            Newstage.setScene(scene);
            Newstage.show();

            Stage loginStage = (Stage) btnVolver.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
