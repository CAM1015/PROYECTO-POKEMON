package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
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
    private ImageView imagenPokemon;

    @FXML
    private Button btnAsignarMote;

    private int numPokedexGenerado;

    String nombrePokemonGenerado = null;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblCapturaResultado.setVisible(false);
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

    @FXML
    public void onGenerarPokemonAleatorioClick(ActionEvent actionEvent) {
            Random random = new Random();
            int randomNumber = random.nextInt(26) + 1;


            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM pokedex WHERE NUM_POKEDEX = " + randomNumber;

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int NUM_POKEDEX = resultSet.getInt("NUM_POKEDEX");
                    String nombrePokemonGenerado = resultSet.getString("NOM_POKEMON");
                    String TIPO1 = resultSet.getString("TIPO1");
                    String TIPO2 = resultSet.getString("TIPO2");
                    String ImagenUrlPokemonGenerado = resultSet.getString("IMAGEN");
                    int NIVEL_EVOLUCION = resultSet.getInt("NIVEL_EVOLUCION");
                    int NUM_POKEDEX_EVO = resultSet.getInt("NUM_POKEDEX_EVO");

                    System.out.println(NUM_POKEDEX + " " + nombrePokemonGenerado + " " + TIPO1 + " " + TIPO2 + " " + ImagenUrlPokemonGenerado + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO);

                    //Carga de imagen
                    Image imagenPokemonGenerado = new Image("file:" + ImagenUrlPokemonGenerado);

                    imagenPokemon.setImage(imagenPokemonGenerado);
                    imagenPokemon.setOpacity(1);

                    lblNombrePokemonSalvaje.setText(nombrePokemonGenerado);
                    lblNombrePokemonSalvaje.setOpacity(1);
                    numPokedexGenerado = NUM_POKEDEX;
                }
            } catch (NullPointerException | SQLException e) {
                System.out.println("CapturaController NullPointerException");
            }
        }



        public void onCapturarClick(ActionEvent actionEvent) {

            Random randomProbabilidadCaptura = new Random();
            int probabilidadCaptura = randomProbabilidadCaptura.nextInt(100) + 1;

            if (probabilidadCaptura < 67) {
                try {
                    Random random = new Random();

                    int numPokedex = numPokedexGenerado;
                    int idEntrenador = SesionController.getInstance().getEntrenadorId();
                    String mote = "Mote por definir.";
                    int caja = 2;
                    int ataque = random.nextInt(10) + 1;
                    int ataqueEspecial = random.nextInt(10) + 1;
                    int defensa = random.nextInt(10) + 1;
                    int defensaEspecial = random.nextInt(10) + 1;
                    int velocidad = random.nextInt(10) + 1;
                    int fertilidad = 5;
                    char sexo = (random.nextBoolean()) ? 'M' : 'F';
                    String estado = "";
                    int experiencia = random.nextInt(10) + 1;
                    int vitalidad = random.nextInt(10) + 1;
                    int idObjeto = 0;
                    int nivel = random.nextInt(10) + 1;




                    Connection connection = DBConnection.getConnection();
                    String insertSql = "INSERT INTO pokemon (NUM_POKEDEX, ID_ENTRENADOR, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO, NIVEL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//insert en pokedex: NOM_POKEMON

                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                        preparedStatement.setInt(1, numPokedex);
                        preparedStatement.setInt(2, idEntrenador);
                        preparedStatement.setString(3, mote);
                        preparedStatement.setInt(4, caja);
                        preparedStatement.setInt(5, ataque);
                        preparedStatement.setInt(6, ataqueEspecial);
                        preparedStatement.setInt(7, defensa);
                        preparedStatement.setInt(8, defensaEspecial);
                        preparedStatement.setInt(9, velocidad);
                        preparedStatement.setInt(10, fertilidad);
                        preparedStatement.setString(11, String.valueOf(sexo));
                        preparedStatement.setString(12, estado);
                        preparedStatement.setInt(13, experiencia);
                        preparedStatement.setInt(14, vitalidad);
                        preparedStatement.setInt(15, idObjeto);
                        preparedStatement.setInt(16, nivel);






                        System.out.println(insertSql);


                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("Pokemon capturado y guardado en la base de datos.");
                        } else {
                            System.out.println("Error al guardar el Pokémon en la base de datos.");
                        }
                    }
                    System.out.println("¡Pokemon capturado!");
                    lblCapturaResultado.setText("¡Pokemon capturado!");
                    lblCapturaResultado.setVisible(true);


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("El pokemon ha escapado :(");
                lblCapturaResultado.setText("El pokemon ha escapado :(");
                lblCapturaResultado.setVisible(true);

            }
                }


    @FXML
    public void onAsignarMoteClick(ActionEvent actionEvent) {
        int ultimoIdPokemon = 0;

        String query = "SELECT MAX(ID_POKEMON) FROM pokemon";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                ultimoIdPokemon = resultSet.getInt(1);

                if (ultimoIdPokemon == 0) {
                    System.out.println("No hay ningún Pokémon capturado para asignarle un mote.");
                    return;
                }
            } else {
                System.out.println("No se pudo obtener el último ID_POKEMON de la base de datos.");
                return;
            }

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Asignar Mote");
            dialog.setHeaderText("Por favor, ingresa el mote para el Pokémon capturado:");
            dialog.setContentText("Mote:");

            final int idPokemonFinal = ultimoIdPokemon;

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(mote -> {
                try (Connection updateConnection = DBConnection.getConnection();
                     PreparedStatement updateStatement = updateConnection.prepareStatement("UPDATE pokemon SET MOTE = ? WHERE ID_POKEMON = ?")) {

                    updateStatement.setString(1, mote);
                    updateStatement.setInt(2, idPokemonFinal);

                    int rowsAffected = updateStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Mote asignado al Pokémon correctamente.");
                    } else {
                        System.out.println("Error al asignar mote al Pokémon.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}