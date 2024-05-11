package es.cesur.progprojectpok.model;

import java.util.LinkedList;

public class Entrenador {

    private int idEntrador;
    private String nomEntrenador;
    private String pass;
    private int pokedollares;
    private LinkedList<Pokemon> equipoPrincipal;
    private LinkedList<Pokemon> pokemonCaja;
    private LinkedList<Objeto> listaObjetos;


    public Entrenador(int idEntrador, String nomEntrenador, String pass, int pokedollares,
                      LinkedList<Pokemon> equipoPrincipal, LinkedList<Pokemon> pokemonCaja, LinkedList<Objeto> listaObjetos) {
        super();
        this.idEntrador = idEntrador;
        this.nomEntrenador = nomEntrenador;
        this.pass = pass;
        this.pokedollares = pokedollares;
        this.equipoPrincipal = equipoPrincipal;
        this.pokemonCaja = pokemonCaja;
        this.listaObjetos = listaObjetos;
    }


    public Entrenador(String usuario, String pass2) {
        super();
        this.idEntrador = 0;
        this.nomEntrenador = usuario;
        this.pass = pass2;
        this.pokedollares = 0;
        this.equipoPrincipal = new LinkedList<Pokemon>();
        this.pokemonCaja = new LinkedList<Pokemon>();
    }


    public int getIdEntrador() {
        return idEntrador;
    }


    public void setIdEntrador(int idEntrador) {
        this.idEntrador = idEntrador;
    }


    public String getNomEntrenador() {
        return nomEntrenador;
    }


    public void setNomEntrenador(String nomEntrenador) {
        this.nomEntrenador = nomEntrenador;
    }


    public String getPass() {
        return pass;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }


    public int getPokedollares() {
        return pokedollares;
    }


    public void setPokedollares(int pokedollares) {
        this.pokedollares = pokedollares;
    }


    public LinkedList<Pokemon> getEquipoPrincipal() {
        return equipoPrincipal;
    }


    public void setEquipoPrincipal(LinkedList<Pokemon> equipoPrincipal) {
        this.equipoPrincipal = equipoPrincipal;
    }


    public LinkedList<Pokemon> getPokemonCaja() {
        return pokemonCaja;
    }


    public void setPokemonCaja(LinkedList<Pokemon> pokemonCaja) {
        this.pokemonCaja = pokemonCaja;
    }


    public LinkedList<Objeto> getListaObjetos() {
        return listaObjetos;
    }


    public void setListaObjetos(LinkedList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }


    @Override
    public String toString() {
        return "Entrenador [idEntrador=" + idEntrador + ", nombre=" + nomEntrenador + ", pass=" + pass + ", pokedollares="
                + pokedollares + ", equipoPrincipal=" + equipoPrincipal + ", pokemonCaja=" + pokemonCaja
                + ", listaObjetos=" + listaObjetos + "]";
    }








}