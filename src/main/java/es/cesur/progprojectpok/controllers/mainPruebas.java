package es.cesur.progprojectpok.controllers;
import es.cesur.progprojectpok.controllers.CentroPokemonController;
import es.cesur.progprojectpok.controllers.SesionController;

public class mainPruebas {

    public static void main(String[] args) {
        // Simular inicio de sesión y obtener el ID del entrenador
        int idEntrenador = 1; // ID de ejemplo

        // Establecer el ID del entrenador en el controlador de sesión
        SesionController.getInstance().setEntrenadorId(idEntrenador);

        // Crear una instancia del controlador del centro Pokémon
        CentroPokemonController centroPokemonController = new CentroPokemonController();

        // Ejecutar el método para mostrar los Pokémon del equipo
        centroPokemonController.mostrarPokemonEquipo();
    }
}
