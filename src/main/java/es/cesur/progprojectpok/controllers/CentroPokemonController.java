package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CentroPokemonController implements Initializable {



    @FXML
    private Button btnVolver;

    @FXML
    private Button btnCurar;

    @FXML
    private FlowPane pokemonFlowPane;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mostrarPokemonEquipo();
    }

    protected void mostrarPokemonEquipo() {

        int idEntrenador = SesionController.getInstance().getEntrenadorId();

        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT pokedex.imagen, pokemon.vitalidad, pokemon.mote " +
                    "FROM pokedex " +
                    "INNER JOIN pokemon ON pokedex.num_pokedex = pokemon.num_pokedex " +
                    "WHERE pokemon.id_entrenador = ? AND pokemon.caja = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idEntrenador);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String rutaImagen = resultSet.getString("IMAGEN");
                int vitalidad = resultSet.getInt("VITALIDAD");
                String mote = resultSet.getString("MOTE");

                System.out.println("Imagen: " + rutaImagen);
                System.out.println("Vitalidad: " + vitalidad);
                System.out.println("Mote: " + mote);

                // Carga la imagen del Pokémon
                Image imagenPokemon = new Image(rutaImagen);
                ImageView imageView = new ImageView(imagenPokemon);

                // Crea un texto para mostrar el nombre, la vitalidad y el mote del Pokémon
                Text textoPokemon = new Text("Vitalidad: " + vitalidad + "\n" +
                        "Mote: " + mote);
                // Establece el tamaño de la imagen
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);

                // Agrega la imagen y el texto al FlowPane
                pokemonFlowPane.getChildren().add(imageView);
                pokemonFlowPane.getChildren().add(textoPokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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


    public void onCurarBtnClick(ActionEvent actionEvent) {
    }





}