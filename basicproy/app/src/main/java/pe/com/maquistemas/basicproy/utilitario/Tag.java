package pe.com.maquistemas.basicproy.utilitario;

public enum Tag {
    SEGUIMIENTO("seguimiento");

    String get;

    Tag(String get) {
        this.get = get;
    }

    public String get() {
        return get;
    }
}
