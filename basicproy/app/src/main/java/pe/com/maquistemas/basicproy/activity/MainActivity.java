package pe.com.maquistemas.basicproy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import pe.com.maquistemas.basicproy.session.SessionUsuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "MainActivity";
    EditText txt_user,txt_password;
    Button btn_login, btn_register;
    final static int REQUEST_CODE_VALIDAR = 1001;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inicializarObjetos();
        inicializarVariables();
    }

    private void inicializarObjetos() {
        this.txt_user = findViewById(R.id.txt_user);
        this.txt_password = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    void inicializarVariables(){
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.session_key), MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_login:
                  if(getUsuario()!= null){
                    intent = new Intent(MainActivity.this, MenuLateralActivity.class);
                    intent.putExtra("key_usuario", this.txt_user.getText().toString());
                    intent.putExtra("key_password", this.txt_password.getText().toString());
                    //startActivityForResult(intent, REQUEST_CODE_VALIDAR );
                    startActivity(intent);
                    finish();
                }

                break;
            case R.id.btn_register:
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }



    Usuario getUsuario(){
        UsuarioDao usuarioDao = AppDatabase.getInstance(getApplicationContext()).usuarioDao();
        Usuario usuario1 = usuarioDao.obtenerPorUsuarioPassword(txt_user.getText().toString().trim(), txt_password.getText().toString().trim());

        if(usuario1 != null){
            Toast.makeText(MainActivity.this, "Bienvenido: " +usuario1.getNombres() +" "+usuario1.getApellidos(), Toast.LENGTH_LONG).show();

            SessionUsuario sessionUsuario = new SessionUsuario(MainActivity.this);
            sessionUsuario.setSessionUsuario(usuario1);
            Log.i(TAG, "Email: "+ sessionUsuario.getUsuarioSession().getEmail());

            return usuario1;
        }else {
            Toast.makeText(MainActivity.this, "Usuario no registrado", Toast.LENGTH_LONG).show();
            return null;
        }

    }






}
