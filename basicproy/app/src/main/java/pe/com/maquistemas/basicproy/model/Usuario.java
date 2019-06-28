package pe.com.maquistemas.basicproy.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Usuario implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String password;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nombres;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nombres);
        dest.writeString(apellidos);
        dest.writeString(usuario);
        dest.writeString(password);
    }

    public Usuario() {
    }

    public Usuario(Parcel in){
        this.id = in.readLong();
        this.nombres = in.readString();
        this.apellidos = in.readString();
        this.usuario = in.readString();
        this.password = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) { return new Usuario(in);}

        @Override
        public Usuario[] newArray(int size) { return new Usuario[size]; }
    };


}
