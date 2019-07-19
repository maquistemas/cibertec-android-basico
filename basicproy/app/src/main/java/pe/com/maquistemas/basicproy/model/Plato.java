package pe.com.maquistemas.basicproy.model;

import java.util.ArrayList;
import java.util.List;

public class Plato {

    private int id;
    private String nombre;
    private String foto;



    public Plato() {
    }

    public Plato(int id, String nombre, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



    public static List<Plato> getPlatos(int tipo){
        List<Plato> platos = new ArrayList<Plato>();
        switch (tipo){
            case 1:
                Plato plato1 = new Plato(1, "Rocoto Relleno","rocotorelleno");
                platos.add(plato1);
                Plato plato2 = new Plato(2, "Ceviche","ceviche");
                platos.add(plato2);
                Plato plato3 = new Plato(3, "Cau Cau","caucau");
                platos.add(plato3);
                Plato plato4 = new Plato(4, "Carapulcra","carapulcra");
                platos.add(plato4);
                Plato plato5 = new Plato(5, "Cabrito a la Norteña","cabritonortena");
                platos.add(plato5);
                Plato plato6 = new Plato(6, "Arroz con Pato","arrozpato");
                platos.add(plato6);
                break;
            case 2:
                Plato plato7 = new Plato(7, "Cabrito a la Norteña","cabritonortena");
                platos.add(plato7);
                Plato plato8 = new Plato(8, "Arroz con Pato","arrozpato");
                platos.add(plato8);
                Plato plato9 = new Plato(9, "Anticuchos","anticucho");
                platos.add(plato9);
                Plato plato10 = new Plato(10, "Ají de Gallina","ajigallina");
                platos.add(plato10);
                break;
        }




        return platos;
    }


}
