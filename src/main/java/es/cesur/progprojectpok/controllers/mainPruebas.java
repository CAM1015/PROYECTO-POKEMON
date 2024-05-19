package es.cesur.progprojectpok.controllers;
import es.cesur.progprojectpok.daos.PokemonDAO;
import es.cesur.progprojectpok.model.Pokemon;
import es.cesur.progprojectpok.model.Movimientos;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static es.cesur.progprojectpok.database.ConfigDB.*;

public class mainPruebas {

    public static void main(String[] args) {
        try {
            // Conectar a la base de datos
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Crear una instancia de PokemonDAO
            PokemonDAO pokemonDAO = new PokemonDAO(connection);

            // Probar obtener un Pokémon por su ID
            int pokemonId = 1; // Cambia este valor a un ID válido en tu base de datos
            Pokemon pokemon = pokemonDAO.getPokemonById(pokemonId);

            if (pokemon != null) {
                System.out.println("Pokémon encontrado: " + pokemon.getMote());
                System.out.println("Num Pokedex: " + pokemon.getNumPokedex());
                System.out.println("ID Entrenador: " + pokemon.getIdEntrenador());
                // Continúa imprimiendo otros atributos si es necesario
            } else {
                System.out.println("No se encontró un Pokémon con el ID: " + pokemonId);
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}