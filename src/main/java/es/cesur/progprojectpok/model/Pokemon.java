package es.cesur.progprojectpok.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

public class Pokemon {
    private int idPokemon;
    private int numPokedex;
    private int idEntrenador;
    private String mote;
    private int caja;
    private int ataque;
    private int atEspecial;
    private int defensa;
    private int defEspecial;
    private int velocidad;
    private int fertilidad;
    private char sexo;
    private String estado;
    private int experiencia;
    private int vitalidad;
    private int idObjeto;
    private int nivel;
    private String nomPokemon;
    private String imagen;
    private List<Movimientos> movimientos;



    public Pokemon(int idPokemon, int numPokedex, int idEntrenador, String mote, int caja, int ataque, int atEspecial, int defensa, int defEspecial, int velocidad, int fertilidad, char sexo, String estado, int experiencia, int vitalidad, int idObjeto, int nivel, String nomPokemon, String imagen, List<Movimientos> movimientos) {
        this.idPokemon = idPokemon;
        this.numPokedex = numPokedex;
        this.idEntrenador = idEntrenador;
        this.mote = mote;
        this.caja = caja;
        this.ataque = ataque;
        this.atEspecial = atEspecial;
        this.defensa = defensa;
        this.defEspecial = defEspecial;
        this.velocidad = velocidad;
        this.fertilidad = fertilidad;
        this.sexo = sexo;
        this.estado = estado;
        this.experiencia = experiencia;
        this.vitalidad = vitalidad;
        this.idObjeto = idObjeto;
        this.nivel = nivel;
        this.nomPokemon = nomPokemon;
        this.imagen = imagen;
        this.movimientos = movimientos;

    }

    public Pokemon() {
    }

    public Pokemon(int idPokemon, String mote, int nivel, int vitalidad, int numPokedex, String nomPokemon, String imagen) {
    }


    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtEspecial() {
        return atEspecial;
    }

    public void setAtEspecial(int atEspecial) {
        this.atEspecial = atEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getDefEspecial() {
        return defEspecial;
    }

    public void setDefEspecial(int defEspecial) {
        this.defEspecial = defEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNomPokemon() {
        return nomPokemon;
    }

    public void setNomPokemon(String nomPokemon) {
        this.nomPokemon = nomPokemon;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "idPokemon=" + idPokemon +
                ", numPokedex=" + numPokedex +
                ", idEntrenador=" + idEntrenador +
                ", mote='" + mote + '\'' +
                ", caja=" + caja +
                ", ataque=" + ataque +
                ", atEspecial=" + atEspecial +
                ", defensa=" + defensa +
                ", defEspecial=" + defEspecial +
                ", velocidad=" + velocidad +
                ", fertilidad=" + fertilidad +
                ", sexo=" + sexo +
                ", estado='" + estado + '\'' +
                ", experiencia=" + experiencia +
                ", vitalidad=" + vitalidad +
                ", idObjeto=" + idObjeto +
                ", nivel=" + nivel +
                ", nomPokemon='" + nomPokemon + '\'' +
                ", imagen='" + imagen + '\'' +
                ", movimientos=" + movimientos +
                '}';
    }
}




