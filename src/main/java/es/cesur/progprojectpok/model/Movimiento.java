package es.cesur.progprojectpok.model;

import java.util.LinkedList;
import javafx.collections.ObservableList;


public abstract class Movimiento {
    private int idMovimiento;
    private int numeroUsos;
    private String nombre;
    public Movimiento() {

    };

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public void setNumeroUsos(int numeroUsos) {
        this.numeroUsos = numeroUsos;
    }

    public int getNumeroUsos() {

        return numeroUsos;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public abstract void ejecutar(Pokemon atacante, Pokemon objetivo);

    public boolean calcularProbabilidad() {
        // Generar un número aleatorio entre 0 y 1
        double random = Math.random();

        // Verificar si el número aleatorio es menor que la probabilidad de éxito del
        // movimiento
        // Si el número aleatorio es menor que 0.8, el movimiento se considera exitoso
        return random < 0.8;
    }

}