package pe.com.maquistemas.basicproy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class ToolbarPersonalizadoActivity extends AppCompatActivity {

    LinearLayout layoutFactura,layoutBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_personalizado);
        setToolbar();
        inicializarObjetos();

    }

    private void inicializarObjetos() {

        layoutFactura=findViewById(R.id.layoutFactura);
        layoutBusqueda=findViewById(R.id.layoutBusqueda);
    }

    private void setToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbar_mitoolbar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable the Up button
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);//no muestra el title por defecto
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_personalizado, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){


            case R.id.action_buscar:

                layoutFactura.setVisibility(View.GONE);
                layoutBusqueda.setVisibility(View.VISIBLE);
                return true;

            default:
                return super.onOptionsItemSelected(item);



        }

    }
}
