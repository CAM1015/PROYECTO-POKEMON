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

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNombreMovimiento() {
        return nombreMovimiento;
    }

    public void setNombreMovimiento(String nombreMovimiento) {
        this.nombreMovimiento = nombreMovimiento;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQuita() {
        return quita;
    }

    public void setQuita(int quita) {
        this.quita = quita;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public int getNivelAprendizaje() {
        return nivelAprendizaje;
    }

    public void setNivelAprendizaje(int nivelAprendizaje) {
        this.nivelAprendizaje = nivelAprendizaje;
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

