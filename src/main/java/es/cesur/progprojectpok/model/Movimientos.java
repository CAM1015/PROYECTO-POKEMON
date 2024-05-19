package es.cesur.progprojectpok.model;

public class Movimientos {
    private int idMovimiento;
    private String nombreMovimiento;
    private int potencia;
    private String tipo;
    private String estado;
    private int quita;
    private int turnos;
    private int nivelAprendizaje;

    public Movimientos (int idMovimiento, String nombreMovimiento, int potencia, String tipo, String estado, int quita, int turnos, int nivelAprendizaje) {
        this.idMovimiento = idMovimiento;
        this.nombreMovimiento = nombreMovimiento;
        this.potencia = potencia;
        this.tipo = tipo;
        this.estado = estado;
        this.quita = quita;
        this.turnos = turnos;
        this.nivelAprendizaje = nivelAprendizaje;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public String getNombreMovimiento() {
        return nombreMovimiento;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public int getQuita() {
        return quita;
    }

    public int getTurnos() {
        return turnos;
    }

    public int getNivelAprendizaje() {
        return nivelAprendizaje;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "idMovimiento=" + idMovimiento +
                ", nombreMovimiento='" + nombreMovimiento + '\'' +
                ", potencia=" + potencia +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                ", quita=" + quita +
                ", turnos=" + turnos +
                ", nivelAprendizaje=" + nivelAprendizaje +
                '}';
    }
}

