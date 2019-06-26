package pe.com.maquistemas.basicproy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pe.com.maquistemas.basicproy.R;

import static pe.com.maquistemas.basicproy.activity.ToolbarPersonalizadoActivity.KEY_TOOLBAR;

public class MenuActivity extends AppCompatActivity implements  View.OnClickListener{

    String usuario ="";
    String password ="";
    Button btPlatosCriollos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        inicializarObjetos();

         this.usuario = getIntent().getStringExtra("key_usuario");
         this.password = getIntent().getStringExtra("key_password");

        login(this.usuario, this.password);


    }

    private void inicializarObjetos() {
        this.btPlatosCriollos = findViewById(R.id.btPlatosCriollos);
        this.btPlatosCriollos.setOnClickListener(this);
    }

    private void login(String usuario, String password) {

        if(usuario != null && password != null){
            if(usuario.equalsIgnoreCase("JOHN") && password.equalsIgnoreCase("123")){
                Toast.makeText(MenuActivity.this, "Bienvenido: "+usuario,Toast.LENGTH_LONG).show();
                ((TextView)findViewById(R.id.tv_mensaje_bienvenida)).setText("Bienvenido: "+usuario);
            }else {
                Toast.makeText(MenuActivity.this, "Usuario no identificado", Toast.LENGTH_LONG).show();
                ((TextView)findViewById(R.id.tv_mensaje_bienvenida)).setText("Usuario no identificado: "+ usuario + " "+password);
            }

        }



    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btPlatosCriollos:
                Intent intent = new Intent(MenuActivity.this, ToolbarPersonalizadoActivity.class);
                intent.putExtra(KEY_TOOLBAR,"clave");
                startActivity(intent);
                break;
        }

    }
}
