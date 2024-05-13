package es.cesur.progprojectpok.model;


import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class Entrenador {

    private int idEntrador;
    private String nomEntrenador;
    private String pass;
    private int pokedollares;
    private ObservableList<Pokemon> equipoPrincipal;
    private ObservableList<Pokemon> pokemonCaja;
    private ObservableList<Objeto> listaObjetos;


    public Entrenador(int idEntrador, String nomEntrenador, String pass, int pokedollares,
                      ObservableList<Pokemon> equipoPrincipal, ObservableList<Pokemon> pokemonCaja, ObservableList<Objeto> listaObjetos) {
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
        this.equipoPrincipal = new ObservableList<Pokemon>() {
            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Pokemon> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Pokemon pokemon) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Pokemon> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Pokemon> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Pokemon get(int index) {
                return null;
            }

            @Override
            public Pokemon set(int index, Pokemon element) {
                return null;
            }

            @Override
            public void add(int index, Pokemon element) {

            }

            @Override
            public Pokemon remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Pokemon> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Pokemon> listIterator(int index) {
                return null;
            }

            @Override
            public List<Pokemon> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(ListChangeListener<? super Pokemon> listChangeListener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Pokemon> listChangeListener) {

            }

            @Override
            public boolean addAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public boolean setAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Pokemon> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public boolean retainAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public void remove(int i, int i1) {

            }
        };
        this.pokemonCaja = new ObservableList<Pokemon>() {
            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Pokemon> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Pokemon pokemon) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Pokemon> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Pokemon> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Pokemon get(int index) {
                return null;
            }

            @Override
            public Pokemon set(int index, Pokemon element) {
                return null;
            }

            @Override
            public void add(int index, Pokemon element) {

            }

            @Override
            public Pokemon remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Pokemon> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Pokemon> listIterator(int index) {
                return null;
            }

            @Override
            public List<Pokemon> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(ListChangeListener<? super Pokemon> listChangeListener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Pokemon> listChangeListener) {

            }

            @Override
            public boolean addAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public boolean setAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Pokemon> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public boolean retainAll(Pokemon... pokemons) {
                return false;
            }

            @Override
            public void remove(int i, int i1) {

            }
        };
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


    public ObservableList<Pokemon> getEquipoPrincipal() {
        return equipoPrincipal;
    }


    public void setEquipoPrincipal(ObservableList<Pokemon> equipoPrincipal) {
        this.equipoPrincipal = equipoPrincipal;
    }


    public ObservableList<Pokemon> getPokemonCaja() {
        return pokemonCaja;
    }


    public void setPokemonCaja(ObservableList<Pokemon> pokemonCaja) {
        this.pokemonCaja = pokemonCaja;
    }


    public ObservableList<Objeto> getListaObjetos() {
        return listaObjetos;
    }


    public void setListaObjetos(ObservableList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }


    @Override
    public String toString() {
        return "Entrenador [idEntrador=" + idEntrador + ", nombre=" + nomEntrenador + ", pass=" + pass + ", pokedollares="
                + pokedollares + ", equipoPrincipal=" + equipoPrincipal + ", pokemonCaja=" + pokemonCaja
                + ", listaObjetos=" + listaObjetos + "]";
    }








}