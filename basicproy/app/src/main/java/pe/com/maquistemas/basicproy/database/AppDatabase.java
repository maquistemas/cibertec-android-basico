package pe.com.maquistemas.basicproy.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pe.com.maquistemas.basicproy.model.Usuario;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context, AppDatabase.class, "usuarios").allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract UsuarioDao usuarioDao();
}
