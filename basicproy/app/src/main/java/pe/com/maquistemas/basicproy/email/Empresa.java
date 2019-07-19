package pe.com.maquistemas.basicproy.email;

public enum Empresa {

    EMPRESA_EMAIL("maquistemastest2019@gmail.com"),
    EMPRESA_EMAIL_PASSWORD("test@2019");

    String value;

    Empresa(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
