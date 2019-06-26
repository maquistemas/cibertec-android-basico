package pe.com.maquistemas.basicproy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.com.maquistemas.basicproy.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txt_user,txt_password;
    Button btn_login;
    final static int REQUEST_CODE_VALIDAR = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inicializarObjetos();
    }

    private void inicializarObjetos() {
        this.txt_user = findViewById(R.id.txt_user);
        this.txt_password = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_login:
                Intent intent = new Intent(MainActivity.this, MenuLateralActivity.class);
                intent.putExtra("key_usuario", this.txt_user.getText().toString());
                intent.putExtra("key_password", this.txt_password.getText().toString());
                //startActivityForResult(intent, REQUEST_CODE_VALIDAR );
                startActivity(intent);
                finish();
                break;
        }

    }
}
