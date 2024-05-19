package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.database.DBConnection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceDialog;
import javafx.util.Duration;

import java.sql.Connection;


public class EquipoController implements Initializable {

@FXML
private Button btnSeleccionarPokemon1;

    @FXML
    private Button btnSeleccionarPokemon2;

    @FXML
    private Text txtRetirar;

@FXML
private Text txtAniadir;

    @FXML
    private Button btnVolver;




    @FXML
    public void onBtnSeleccionarPokemon1Click() {
        List<String> motesPokemonCaja1 = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT MOTE FROM pokemon WHERE CAJA = 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String mote = resultSet.getString("MOTE");
                motesPokemonCaja1.add(mote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if (motesPokemonCaja1.isEmpty()) {
            return;
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(motesPokemonCaja1.get(0), motesPokemonCaja1);
        dialog.setTitle("Seleccionar Pokémon");
        dialog.setHeaderText("Seleccionar un Pokémon del equipo principal");
        dialog.setContentText("Elige un Pokémon:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(motePokemon -> {
            actualizarCajaPokemon(motePokemon, 2);
            mostrarMensajeTransferencia(motePokemon);

        });
    }

    private void actualizarCajaPokemon(String motePokemon, int nuevaCaja) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE pokemon SET CAJA = ? WHERE MOTE = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nuevaCaja);
            preparedStatement.setString(2, motePokemon);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensajeTransferencia(String motePokemon) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Transferencia de Pokémon");
        alert.setHeaderText(null);
        alert.setContentText(motePokemon + " se ha transferido a la caja 2.");
        alert.show();

        // Cerrar el cuadro de diálogo después de 3 segundos
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> alert.close()));
        timeline.play();
    }


    @FXML
    public void onBtnSeleccionarPokemon2Click() {
        List<String> motesPokemonCaja2 = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT MOTE FROM pokemon WHERE CAJA = 2";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String mote = resultSet.getString("MOTE");
                motesPokemonCaja2.add(mote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if (motesPokemonCaja2.isEmpty()) {
            return;
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(motesPokemonCaja2.get(0), motesPokemonCaja2);
        dialog.setTitle("Seleccionar Pokémon");
        dialog.setHeaderText("Seleccionar un Pokémon de la Caja 2");
        dialog.setContentText("Elige un Pokémon:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(motePokemon -> {
            actualizarCajaPokemon2(motePokemon, 1);
            mostrarMensajeTransferencia2(motePokemon);

        });
    }
    private void actualizarCajaPokemon2(String motePokemon, int nuevaCaja) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE pokemon SET CAJA = ? WHERE MOTE = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nuevaCaja);
            preparedStatement.setString(2, motePokemon);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensajeTransferencia2(String motePokemon) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Transferencia de Pokémon");
        alert.setHeaderText(null);
        alert.setContentText(motePokemon + " se ha transferido al equipo principal.");
        alert.show();

        // Cerrar el cuadro de diálogo después de 3 segundos
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> alert.close()));
        timeline.play();
    }

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }



}
