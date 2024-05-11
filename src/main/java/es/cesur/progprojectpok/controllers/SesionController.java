package es.cesur.progprojectpok.controllers;


public class SesionController{
    private static SesionController instance;
    private int idEntrenador;
    private String nombreEntrenador;
    private SesionController() {

    }

    public static SesionController getInstance() {
        if (instance == null) {
            instance = new SesionController();
        }
        return instance;
    }

    public void setEntrenadorId(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public int getEntrenadorId() {
        return idEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public void cerrarSesion() {
        this.idEntrenador = 0;
        this.nombreEntrenador = null;
    }

    public boolean usuarioHaIniciadoSesion() {
        return idEntrenador != 0;
    }
}

