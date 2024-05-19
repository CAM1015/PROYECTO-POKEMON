package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.model.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TextField txtMote1;

    @FXML
    private TextField txtMote2;

    @FXML
    private TextField txtMote3;

    @FXML
    private TextField txtMote4;

    @FXML
    private TextField txtMote5;

    @FXML
    private TextField txtMote6;

    @FXML
    private TextField txtVitalidad1;

    @FXML
    private TextField txtVitalidad2;

    @FXML
    private TextField txtVitalidad3;

    @FXML
    private TextField txtVitalidad4;

    @FXML
    private TextField txtVitalidad5;

    @FXML
    private TextField txtVitalidad6;

    @FXML
    private ImageView imagenPokemon1;

    @FXML
    private ImageView imagenPokemon2;

    @FXML
    private ImageView imagenPokemon3;

    @FXML
    private ImageView imagenPokemon4;

    @FXML
    private ImageView imagenPokemon5;

    @FXML
    private ImageView imagenPokemon6;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Inicializando la pantalla...");
        mostrarPokemonEquipo();
        System.out.println("Inicialización completada.");
    }

    protected void mostrarPokemonEquipo() {
        System.out.println("Mostrando Pokémon del equipo...");

        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT p.IMAGEN, pk.MOTE, pk.VITALIDAD FROM POKEMON pk " +
                    "JOIN POKEDEX p ON pk.NUM_POKEDEX = p.NUM_POKEDEX " +
                    "WHERE pk.CAJA = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int index = 1; // Para llevar la cuenta de la posición del Pokémon en la caja
            while (resultSet.next() && index <= 6) { // Mostrar solo los primeros 6 Pokémon
                String imagenPokemon = resultSet.getString("IMAGEN");
                String motePokemon = resultSet.getString("MOTE");
                int vitalidadPokemon = resultSet.getInt("VITALIDAD");

                // Asignar la imagen al ImageView correspondiente
                String rutaImagen = "file:" + imagenPokemon;
                Image imagen = new Image(rutaImagen);
                System.out.println("Imagen: " + imagenPokemon);
                System.out.println("Mote: " + motePokemon);
                System.out.println("Vitalidad: " + vitalidadPokemon);

                switch (index) {
                    case 1:
                        imagenPokemon1.setImage(imagen);
                        txtMote1.setText( motePokemon);
                        txtVitalidad1.setText(String.valueOf(vitalidadPokemon));
                        break;
                    case 2:
                        imagenPokemon2.setImage(imagen);
                        txtMote2.setText(motePokemon);
                        txtVitalidad2.setText(String.valueOf(vitalidadPokemon));
                        break;
                    case 3:
                        imagenPokemon3.setImage(imagen);
                        txtMote3.setText(motePokemon);
                        txtVitalidad3.setText(String.valueOf(vitalidadPokemon));
                        break;
                    case 4:
                        imagenPokemon4.setImage(imagen);
                        txtMote4.setText(motePokemon);
                        txtVitalidad4.setText(String.valueOf(vitalidadPokemon));
                        break;
                    case 5:
                        imagenPokemon5.setImage(imagen);
                        txtMote5.setText(motePokemon);
                        txtVitalidad5.setText(String.valueOf(vitalidadPokemon));
                        break;
                    case 6:
                        imagenPokemon6.setImage(imagen);
                        txtMote6.setText(motePokemon);
                        txtVitalidad6.setText(String.valueOf(vitalidadPokemon));
                        break;
                }
                index++;
            }
            System.out.println("Pokémon del equipo mostrados exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al mostrar los Pokémon del equipo: " + e.getMessage());

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
        try (Connection connection = DBConnection.getConnection()) {
            String updateQuery = "UPDATE POKEMON SET VITALIDAD = 200 WHERE VITALIDAD < 200 AND CAJA = 1";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Se han curado " + rowsAffected + " Pokémon.");
                // Actualizar la pantalla para reflejar los cambios
                mostrarPokemonEquipo();
            } else {
                System.out.println("No hay Pokémon para curar o su vitalidad ya está al máximo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al curar los Pokémon: " + e.getMessage());
        }
    }
}
