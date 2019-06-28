package pe.com.maquistemas.basicproy.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

import pe.com.maquistemas.basicproy.model.Usuario;

@Dao
public interface UsuarioDao {
    @Query("SELECT * from usuario")
    List<Usuario> listar();

    @Insert
    long insertar(Usuario usuario);

    @Update
    int actualizar(Usuario usuario);

    @Delete
    int eliminar(Usuario usuario);

    @Query("SELECT * FROM usuario WHERE id = :id")
    Cursor obtenerPorId(long id);

    @Query("SELECT * FROM usuario WHERE usuario = :usuario AND password = :password")
    Usuario obtenerPorUsuarioPassword(String usuario, String password);
}
