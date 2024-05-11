package es.cesur.progprojectpok.model;

public enum Tipo {
    NORMAL("Normal"),
    FUEGO("Fuego"),
    AGUA("Agua"),
    ELECTRICO("Eléctrico"),
    PLANTA("Planta"),
    HIELO("Hielo"),
    LUCHA("Lucha"),
    VENENO("Veneno"),
    TIERRA("Tierra"),
    VOLADOR("Volador"),
    PSIQUICO("Psíquico"),
    BICHO("Bicho"),
    ROCA("Roca"),
    FANTASMA("Fantasma"),
    DRAGON("Dragón"),
    OSCURO("Oscuro"),
    ACERO("Acero"),
    HADA("Hada");

    private final String nombre;

    Tipo (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    // Método estático para convertir una cadena a un valor del enumerado
    public static Tipo convertirTipoDesdeString(String tipoString){
        for (Tipo tipo : Tipo.values()) {
            if(tipo.getNombre().toUpperCase().equalsIgnoreCase(tipoString)) {
                return tipo;
            }
        }
        return null;
    }

}
