package pe.com.maquistemas.basicproy.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.model.Usuario;

public class SessionUsuario {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private final String SESSION_USUARIO_KEY = "SESSION_USUARIO_KEY";
    Context context;

    public SessionUsuario(Context context) {
        this.context = context;
        inicializarVariables();
    }


    void inicializarVariables(){
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.session_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setSessionUsuario(Usuario usuario){

        //Limpiamos variables de session si existen
        String sharedUser = sharedPreferences.getString(context.getResources().getString(R.string.sesion_usuario_usuario),"");
        if(  sharedUser != null  ){
            editor.remove(context.getResources().getString(R.string.sesion_usuario_nombres));
            editor.remove(context.getResources().getString(R.string.sesion_usuario_apellidos));
            editor.remove(context.getResources().getString(R.string.sesion_usuario_usuario));
            editor.remove(context.getResources().getString(R.string.sesion_usuario_email));
            editor.apply();
        }

        //guardamos las variables de session
        editor.putString(context.getResources().getString(R.string.sesion_usuario_nombres), usuario.getNombres());
        editor.putString(context.getResources().getString(R.string.sesion_usuario_apellidos), usuario.getApellidos());
        editor.putString(context.getResources().getString(R.string.sesion_usuario_usuario), usuario.getUsuario());
        editor.putString(context.getResources().getString(R.string.sesion_usuario_email), usuario.getEmail());
        editor.apply();//asincrono
        editor.commit();//sincrono

    }

    public Usuario getUsuarioSession(){

        return new Usuario(
                sharedPreferences.getString(context.getResources().getString(R.string.sesion_usuario_nombres),""),
                sharedPreferences.getString(context.getResources().getString(R.string.sesion_usuario_apellidos),""),
                sharedPreferences.getString(context.getResources().getString(R.string.sesion_usuario_email),""),
                sharedPreferences.getString(context.getResources().getString(R.string.sesion_usuario_usuario),"")
        );
    }




}
