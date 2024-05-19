package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.model.Movimientos;
import es.cesur.progprojectpok.model.Pokemon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class CombateController implements Initializable {


    @FXML
    private Button btnVolver;

    @FXML
    private ImageView imagenPokemonRival;

    @FXML
    private ImageView imagenPokemon;

    @FXML
    private Label lblNombreRival;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblNivelRival;

    @FXML
    private Label lblNivel;

    @FXML
    private Label lblVitalidadRival;

    @FXML
    private Label lblVitalidad;

    @FXML
    private Button btnAtacar;

    @FXML
    private Button btnSeleccionarAtaque;

    @FXML
    private Button btnSeleccionarMovimiento;

    @FXML
    private Label lblAcciones;

    @FXML
    private Button btnEncontrarRival;

    @FXML
    private Button btnSeleccionarPokemon;


    private int numPokedexGenerado;
    private int nivelAleatorio;
    private int vitalidadAleatoria;

    private int cajaSeleccionada;

    private List<Pokemon> pokemonDeCaja;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pokemonDeCaja = new ArrayList<>();
    }

    @FXML
    public void onEncontrarRivalBtnClick() {
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

                int nivelAleatorio = random.nextInt(10) + 1;

                int vitalidadAleatoria = 200;

                System.out.println(NUM_POKEDEX + " " + nombrePokemonGenerado + " " + TIPO1 + " " + TIPO2 + " " + ImagenUrlPokemonGenerado + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO);
                System.out.println("Nivel del Pokémon rival: " + nivelAleatorio);
                System.out.println("Vitalidad del Pokémon rival: " + vitalidadAleatoria);


                // Consulta para obtener los movimientos asociados al Pokémon generado
                String sqlMovimientos = "SELECT M.* FROM MOVIMIENTOS M " +
                        "JOIN POKEDEX_MOVIMIENTOS PM ON M.ID_MOVIMIENTO = PM.ID_MOVIMIENTO " +
                        "WHERE PM.NUM_POKEDEX = " + NUM_POKEDEX;

                PreparedStatement preparedStatementMovimientos = connection.prepareStatement(sqlMovimientos);
                ResultSet resultSetMovimientos = preparedStatementMovimientos.executeQuery();

                List<Movimientos> movimientosRival = new ArrayList<>();

                while (resultSetMovimientos.next()) {
                    int idMovimiento = resultSetMovimientos.getInt("ID_MOVIMIENTO");
                    String nombreMovimiento = resultSetMovimientos.getString("NOMBRE_MOV");
                    int potencia = resultSetMovimientos.getInt("POTENCIA");
                    String tipo = resultSetMovimientos.getString("TIPO");
                    String estado = resultSetMovimientos.getString("ESTADO");
                    int quita = resultSetMovimientos.getInt("QUITA");
                    int turnos = resultSetMovimientos.getInt("TURNOS");
                    int nivelAprendizaje = resultSetMovimientos.getInt("NIVEL_APRENDIZAJE");

                    Movimientos movimiento = new Movimientos (idMovimiento, nombreMovimiento, potencia, tipo, estado, quita, turnos, nivelAprendizaje);
                    movimientosRival.add(movimiento);

                    // Aquí puedes procesar cada movimiento obtenido según tus necesidades
                    System.out.println("Movimiento: " + nombreMovimiento + ", Potencia: " + potencia + ", Tipo: " + tipo + ", Estado: " + estado + ", Quita: " + quita + ", Turnos: " + turnos + ", Nivel de aprendizaje: " + nivelAprendizaje);
                    // Puedes almacenarlos en una lista o mostrarlos en la interfaz gráfica si es necesario
                }


                //Carga de imagen
                Image imagenPokemonGenerado = new Image("file:" + ImagenUrlPokemonGenerado);

                imagenPokemonRival.setImage(imagenPokemonGenerado);
                imagenPokemonRival.setOpacity(1);

                lblNombreRival.setText(nombrePokemonGenerado);
                lblNombreRival.setOpacity(1);
                numPokedexGenerado = NUM_POKEDEX;

                lblNivelRival.setText("Nivel: " + nivelAleatorio);
                lblVitalidadRival.setText("HP: " + vitalidadAleatoria);

            }
        } catch (NullPointerException | SQLException e) {
            System.out.println("CapturaController NullPointerException");
        }

    }



    @FXML
    private void onSeleccionarEquipoBtnClick() {

        List<Integer> choices = new ArrayList<>();
        for (int i = 1; i <= 10; i++) { // Suponiendo que tienes 10 cajas
            choices.add(i);
        }

        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
        dialog.setTitle("Seleccionar Caja");
        dialog.setHeaderText("Seleccionar Caja de Pokémon");
        dialog.setContentText("Elige una caja:");

        Optional<Integer> result = dialog.showAndWait();
        result.ifPresent(caja -> cargarPokemonDeCaja(caja));
    }

    private void cargarPokemonDeCaja(int caja) {
        pokemonDeCaja.clear(); // Limpiar la lista de Pokémon cargados anteriormente
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT p.*, px.NOM_POKEMON, px.IMAGEN FROM pokemon p " +
                "JOIN pokedex px ON p.NUM_POKEDEX = px.NUM_POKEDEX WHERE p.caja = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, caja);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPokemon = resultSet.getInt("ID_POKEMON");
                String mote = resultSet.getString("MOTE");
                int nivel = resultSet.getInt("NIVEL");
                int vitalidad = resultSet.getInt("VITALIDAD");
                int numPokedex = resultSet.getInt("NUM_POKEDEX");
                String nombrePokemon = resultSet.getString("NOM_POKEMON");
                String imagen = resultSet.getString("IMAGEN");

                // Imprimir los datos recuperados para depuración
                System.out.println("ID Pokemon: " + idPokemon);
                System.out.println("Mote: " + mote);
                System.out.println("Nivel: " + nivel);
                System.out.println("Vitalidad: " + vitalidad);
                System.out.println("Num Pokedex: " + numPokedex);
                System.out.println("Nombre Pokemon: " + nombrePokemon);
                System.out.println("Imagen: " + imagen);

                if (mote == null || nombrePokemon == null || imagen == null) {
                    System.out.println("Error: Datos nulos recuperados de la base de datos.");
                    continue; // Saltar este Pokémon si hay datos nulos
                }

                Pokemon pokemon = new Pokemon(idPokemon, mote, nivel, vitalidad, numPokedex, nombrePokemon, imagen);
                pokemonDeCaja.add(pokemon);

                System.out.println("ID Pokemon: " + idPokemon + ", Nombre: " + mote + ", Nivel: " + nivel + ", Vitalidad: " + vitalidad + ", Num Pokedex: " + numPokedex + ", Nombre Pokemon: " + nombrePokemon + ", Imagen: " + imagen);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onSeleccionarPokemonBtnClick() {
        if (pokemonDeCaja.isEmpty()) {
            // Mostrar un mensaje de error si no hay Pokémon en la caja
            System.out.println("No hay Pokémon en la caja seleccionada.");
            return;
        }

        List<String> choices = new ArrayList<>();
        for (Pokemon pokemon : pokemonDeCaja) {
            String displayName = pokemon.getNombre() != null ? pokemon.getNombre() : "null";
            int displayNivel = pokemon.getNivel();
            choices.add(displayName + " (Nivel: " + displayNivel + ")");
        }

        // Mensajes de depuración
        for (String choice : choices) {
            System.out.println("Choice: " + choice);
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Seleccionar Pokémon");
        dialog.setHeaderText("Seleccionar un Pokémon de la Caja");
        dialog.setContentText("Elige un Pokémon:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(pokemonNombre -> {
            for (Pokemon pokemon : pokemonDeCaja) {
                if ((pokemon.getNombre() + " (Nivel: " + pokemon.getNivel() + ")").equals(pokemonNombre)) {
                    actualizarInterfazConPokemon(pokemon);
                    break;
                }
            }
        });
    }
    private void actualizarInterfazConPokemon(Pokemon pokemon) {
        lblNombre.setText(pokemon.getNombre());
        lblNivel.setText("Nivel: " + pokemon.getNivel());
        lblVitalidad.setText("HP: " + pokemon.getVitalidad());

        Image imagen = new Image("file:" + pokemon.getImagen());
        imagenPokemon.setImage(imagen);
        imagenPokemon.setOpacity(1);
    }


    @FXML
    private void onSeleccionarAtaqueBtnClick() {

    }

    @FXML
    private void onAtacarBtnClick() {

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




}
