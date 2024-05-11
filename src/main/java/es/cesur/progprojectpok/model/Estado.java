package es.cesur.progprojectpok.model;

public enum Estado {
    PARALIZADO("PARALIZADO"), // Ordinal nos indica el orden en este caso es: 0
    QUEMADO("QUEMADO"), // Ordinal nos indica el orden en este caso es: 1
    ENVENENADO("ENVENENADO"), // Ordinal nos indica el orden en este caso es: 2
    GRAVEMENTE_ENVENENADO("GRAVEMENTE_ENVENENADO"), // Ordinal nos indica el orden en este caso es: 3
    DORMIDO("DORMIDO"), // Ordinal nos indica el orden en este caso es: 4
    CONGELADO("CONGELADO"), // Ordinal nos indica el orden en este caso es: 5
    HELADO("HELADO"), // Ordinal nos indica el orden en este caso es: 6
    SOMNOLIENTO("SOMNOLIENTO"), // Ordinal nos indica el orden en este caso es: 7
    POKERUS("POKERUS"), // Ordinal nos indica el orden en este caso es: 8
    DEBILITADO("DEBILITADO"), // Ordinal nos indica el orden en este caso es: 9
    CONFUSO("CONFUSO"), // Ordinal nos indica el orden en este caso es: 10
    ENAMORADO("ENAMORADO"), // Ordinal nos indica el orden en este caso es: 11
    ATRAPADO("ATRAPADO"), // Ordinal nos indica el orden en este caso es: 12
    MALDITO("MALDITO"), // Ordinal nos indica el orden en este caso es: 13
    DRENADORAS("DRENADORAS"), // Ordinal nos indica el orden en este caso es: 14
    CANTO_MORTAL("CANTO_MORTAL"), CENTRO_DE_ATENCION("CENTRO_DE_ATENCION"), AMEDRENTADO("AMEDRENTADO"),
    NORMAL("NORMAL");

    private final String nombre;

    Estado (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Estado convertirEstadoDesdeString(String tipoString) {
        for (Estado est : Estado.values()) {
            if (est.getNombre().toUpperCase().equalsIgnoreCase(tipoString)) {
                return est;
            }
        }
        return null;
    }
}