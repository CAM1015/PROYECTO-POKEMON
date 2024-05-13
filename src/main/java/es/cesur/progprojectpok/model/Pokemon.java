package es.cesur.progprojectpok.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

import java.util.LinkedList;

public class Pokemon {

    public final int EXPERIENCIA_SUBIR_NIVEL = 10;

    private int idPokemon;
    private int numPokedex;
    private String nombre;
    private String mote;
    private int nivel;
    private int experiencia;
    private int vitalidad;
    private int vitalidadActual;
    private int ataque;
    private int ataqueEspecial;
    private int defensa;
    private int defensaEspecial;
    private int velocidad;

    private int fertilidad;
    private boolean sexo;
    static ObservableList<Movimiento> movimientos;
    static Tipo tipo1;
    static Tipo tipo2;
    private int nivelEvolucion;
    private String estado;
    private Objeto objeto;
    private String imgFrontal;
    private String imgTrasera;


    public Pokemon() {
        super();
        this.idPokemon = 0;
        this.numPokedex = 0;
        this.nombre = "";
        this.mote = "";
        this.nivel = 1;
        this.experiencia = 0;
        this.vitalidad = 1;
        this.vitalidadActual = 1;
        this.ataque = 1;
        this.ataqueEspecial = 1;
        this.defensa = 1;
        this.defensaEspecial = 1;
        this.velocidad = 1;
        this.fertilidad = 5;
        this.sexo = true;    //true es macho
        this.movimientos = null;
        this.tipo1 = null;
        this.tipo2 = null;
        this.nivelEvolucion = 0;
        this.estado = "";
        this.objeto = null;
        this.imgFrontal = "";
        this.imgTrasera = "";
    }

    /**
     * Constructor Pokédex
     *
     * @param numPokedex
     * @param nombre
     * @param tipo1
     * @param tipo2
     * @param nivelEvolucion
     * @param imgFrontal
     * @param imgTrasera
     */
    public Pokemon(int numPokedex, String nombre, Tipo tipo1, Tipo tipo2,
                   int nivelEvolucion, String imgFrontal, String imgTrasera) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivelEvolucion = nivelEvolucion;
        this.imgFrontal = imgFrontal;
        this.imgTrasera = imgTrasera;
    }
    /**
     * Constructor copia
     *
     * @param p
     */
    public Pokemon(Pokemon p) {
        this.idPokemon = p.idPokemon;
        this.numPokedex = p.numPokedex;
        this.nombre = p.nombre;
        this.mote = p.mote;
        this.nivel = p.nivel;
        this.experiencia = p.experiencia;
        this.vitalidad = p.vitalidad;
        this.vitalidadActual = p.vitalidadActual;
        this.ataque = p.ataque;
        this.ataqueEspecial = p.ataqueEspecial;
        this.defensa = p.defensa;
        this.defensaEspecial = p.defensaEspecial;
        this.velocidad = p.velocidad;
        this.fertilidad = p.fertilidad;
        this.sexo = p.sexo;
        this.movimientos = p.movimientos;
        this.tipo1 = p.tipo1;
        this.tipo2 = p.tipo2;
        this.nivelEvolucion = p.nivelEvolucion;
        this.estado = p.estado;
        this.objeto = p.objeto;
        this.imgFrontal = p.imgFrontal;
        this.imgTrasera = p.imgTrasera;
    }

    /**
     * Constructor completo.
     *
     * @param idPokemon
     * @param numPokedex
     * @param nombre
     * @param mote
     * @param nivel
     * @param experiencia
     * @param vitalidad
     * @param vitalidadActual
     * @param ataque
     * @param ataqueEspecial
     * @param defensa
     * @param defensaEspecial
     * @param velocidad
     * @param fertilidad
     * @param sexo
     * @param movimientos
     * @param tipo1
     * @param tipo2
     * @param nivelEvolucion
     * @param estado
     * @param objeto
     * @param imgFrontal
     * @param imgTrasera
     */
    public Pokemon(int idPokemon, int numPokedex, String nombre, String mote, int nivel, int experiencia,
                   int vitalidad, int vitalidadActual, int ataque, int ataqueEspecial, int defensa, int defensaEspecial,
                   int velocidad, int estamina, int estaminaActual, int fertilidad, boolean sexo,
                   ObservableList<Movimiento> movimientos , Tipo tipo1, Tipo tipo2, int nivelEvolucion,
                   String estado, Objeto objeto, String imgFrontal, String imgTrasera) {
        super();
        this.idPokemon = idPokemon;
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.mote = mote;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.vitalidad = vitalidad;
        this.vitalidadActual = vitalidadActual;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defensa = defensa;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.fertilidad = fertilidad;
        this.sexo = sexo;
        this.movimientos = movimientos;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivelEvolucion = nivelEvolucion;
        this.estado = estado;
        this.objeto = objeto;
        this.imgFrontal = imgFrontal;
        this.imgTrasera = imgTrasera;
    }


    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getVitalidadActual() {
        return vitalidadActual;
    }

    public void setVitalidadActual(int vitalidadActual) {
        this.vitalidadActual = vitalidadActual;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
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

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static ObservableList<Movimiento> getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(ObservableList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }


    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public static Tipo getTipoPrimario() {
        return tipo1;
    }

    public void setTipoPrimario(Tipo tipo1) {
        Pokemon.tipo1 = tipo1;
    }

    public static  Tipo getTipoSecundario() {
        return tipo2;
    }

    public void setTipoSecundario(Tipo tipo2) {
        Pokemon.tipo2 = tipo2;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public String getImgFrontal() {
        return imgFrontal;
    }

    public void setImgFrontal(String imgFrontal) {
        this.imgFrontal = imgFrontal;
    }

    public String getImgTrasera() {
        return imgTrasera;
    }

    public void setImgTrasera(String imgTrasera) {
        this.imgTrasera = imgTrasera;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivelEvolucion() {
        return nivelEvolucion;
    }

    public void setNivelEvolucion(int nivelEvolucion) {
        this.nivelEvolucion = nivelEvolucion;
    }



    public IntegerProperty vitalidadProperty() {
        return new SimpleIntegerProperty(this, "vitalidad", vitalidad);
    }
}