package es.cesur.progprojectpok.model;

public class Pokedex {

        private int numPokedex;
        private String nomPokemon;
        private String tipo1;
        private String tipo2;
        private String imagen;
        private String sonido;
        private Integer nivelEvolucion;
        private Integer numPokedexEvo;

        // Constructor
        public Pokedex(int numPokedex, String nomPokemon, String tipo1, String tipo2,
                       String imagen, String sonido, Integer nivelEvolucion, Integer numPokedexEvo) {
            this.numPokedex = numPokedex;
            this.nomPokemon = nomPokemon;
            this.tipo1 = tipo1;
            this.tipo2 = tipo2;
            this.imagen = imagen;
            this.sonido = sonido;
            this.nivelEvolucion = nivelEvolucion;
            this.numPokedexEvo = numPokedexEvo;
        }

        // Getters and Setters
        public int getNumPokedex() {
            return numPokedex;
        }

        public void setNumPokedex(int numPokedex) {
            this.numPokedex = numPokedex;
        }

        public String getNomPokemon() {
            return nomPokemon;
        }

        public void setNomPokemon(String nomPokemon) {
            this.nomPokemon = nomPokemon;
        }

        public String getTipo1() {
            return tipo1;
        }

        public void setTipo1(String tipo1) {
            this.tipo1 = tipo1;
        }

        public String getTipo2() {
            return tipo2;
        }

        public void setTipo2(String tipo2) {
            this.tipo2 = tipo2;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getSonido() {
            return sonido;
        }

        public void setSonido(String sonido) {
            this.sonido = sonido;
        }

        public Integer getNivelEvolucion() {
            return nivelEvolucion;
        }

        public void setNivelEvolucion(Integer nivelEvolucion) {
            this.nivelEvolucion = nivelEvolucion;
        }

        public Integer getNumPokedexEvo() {
            return numPokedexEvo;
        }

        public void setNumPokedexEvo(Integer numPokedexEvo) {
            this.numPokedexEvo = numPokedexEvo;
        }

        @Override
        public String toString() {
            return "Pokedex{" +
                    "numPokedex=" + numPokedex +
                    ", nomPokemon='" + nomPokemon + '\'' +
                    ", tipo1='" + tipo1 + '\'' +
                    ", tipo2='" + tipo2 + '\'' +
                    ", imagen='" + imagen + '\'' +
                    ", sonido='" + sonido + '\'' +
                    ", nivelEvolucion=" + nivelEvolucion +
                    ", numPokedexEvo=" + numPokedexEvo +
                    '}';
        }
    }
