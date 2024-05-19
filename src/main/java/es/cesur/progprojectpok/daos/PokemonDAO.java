package es.cesur.progprojectpok.daos;
import es.cesur.progprojectpok.model.Pokemon;
import es.cesur.progprojectpok.model.Movimientos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonDAO {

    private Connection connection;

    public PokemonDAO(Connection connection) {
        this.connection = connection;
    }

    public Pokemon getPokemonById(int id) {
        Pokemon pokemon = null;
        String query = "SELECT * FROM pokemon WHERE ID_POKEMON = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                pokemon = new Pokemon();
                pokemon.setIdPokemon(resultSet.getInt("ID_POKEMON"));
                pokemon.setNumPokedex(resultSet.getInt("NUM_POKEDEX"));
                pokemon.setIdEntrenador(resultSet.getInt("ID_ENTRENADOR"));
                pokemon.setMote(resultSet.getString("MOTE"));
                pokemon.setCaja(resultSet.getInt("CAJA"));
                pokemon.setAtaque(resultSet.getInt("ATAQUE"));
                pokemon.setAtEspecial(resultSet.getInt("AT_ESPECIAL"));
                pokemon.setDefensa(resultSet.getInt("DEFENSA"));
                pokemon.setDefEspecial(resultSet.getInt("DEF_ESPECIAL"));
                pokemon.setVelocidad(resultSet.getInt("VELOCIDAD"));
                pokemon.setFertilidad(resultSet.getInt("FERTILIDAD"));
                pokemon.setSexo(resultSet.getString("SEXO").charAt(0));
                pokemon.setEstado(resultSet.getString("ESTADO"));
                pokemon.setExperiencia(resultSet.getInt("EXPERIENCIA"));
                pokemon.setVitalidad(resultSet.getInt("VITALIDAD"));
                pokemon.setIdObjeto(resultSet.getInt("ID_OBJETO"));
                pokemon.setNivel(resultSet.getInt("NIVEL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemon;


    }
}