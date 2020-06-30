package app;

public enum Locations {
    CENTER("c"),BOTTOM("b"),TOP("t");

    private final String codigo;

    Locations(String c) {
        this.codigo = c;
    }

    public static Locations escolherLocalizacao(String c){
        for (Locations locations : Locations.values()) {
            if (c == locations.codigo) {
                return locations;
            }
        }
        throw new IllegalArgumentException();
    }
}
