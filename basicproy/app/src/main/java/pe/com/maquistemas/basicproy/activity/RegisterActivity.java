package pe.com.maquistemas.basicproy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.database.AppDatabase;
import pe.com.maquistemas.basicproy.database.UsuarioDao;
import pe.com.maquistemas.basicproy.model.Usuario;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNombres, etApellidos, etUsuario, etPassword;
    Button btRegistrar, btLimpiar;
    Usuario usuario;

    static final String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.iniciarObjetos();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btRegistrar:
                registrarUsuario();
                break;
            case R.id.btLimpiar:

                break;
        }

    }





   void iniciarObjetos(){
        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btRegistrar = findViewById(R.id.btRegistrar);
        btLimpiar = findViewById(R.id.btLimpiar);
       btRegistrar.setOnClickListener(this);
       btLimpiar.setOnClickListener(this);
    }

    void registrarUsuario(){
        usuario = new Usuario();
        usuario.setNombres(etNombres.getText().toString());
        usuario.setApellidos(etApellidos.getText().toString());
        usuario.setUsuario(etUsuario.getText().toString());
        usuario.setPassword(etPassword.getText().toString());
        try {
            UsuarioDao usuarioDao = AppDatabase.getInstance(getApplicationContext()).usuarioDao();
            usuarioDao.insertar(usuario);
            Toast.makeText(RegisterActivity.this,"Se registro satisfactoriamente",Toast.LENGTH_LONG).show();
            Log.i(TAG, "Se registro satisfactoriamente");
        }catch (Exception e){
            Toast.makeText(RegisterActivity.this,"Error al registrar",Toast.LENGTH_LONG).show();
            Log.e(TAG,e.getMessage());
        }
    }

    void limpiar(){
        etNombres.setText("");
        etApellidos.setText("");
        etUsuario.setText("");
        etPassword.setText("");
    }


}
