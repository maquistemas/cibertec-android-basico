package pe.com.maquistemas.basicproy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    String usuario ="";
    String password ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

         this.usuario = getIntent().getStringExtra("key_usuario");
         this.password = getIntent().getStringExtra("key_password");

        login(this.usuario, this.password);


    }

    private void login(String usuario, String password) {

        if(usuario.equalsIgnoreCase("JOHN") && password.equalsIgnoreCase("123")){
            Toast.makeText(MenuActivity.this, "Bienvenido: "+usuario,Toast.LENGTH_LONG).show();
            ((TextView)findViewById(R.id.tv_mensaje_bienvenida)).setText("Bienvenido: "+usuario);
        }else {
            Toast.makeText(MenuActivity.this, "Usuario no identificado", Toast.LENGTH_LONG).show();
            ((TextView)findViewById(R.id.tv_mensaje_bienvenida)).setText("Usuario no identificado: "+ usuario + " "+password);
        }



    }


}
