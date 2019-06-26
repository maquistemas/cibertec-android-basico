package pe.com.maquistemas.basicproy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.adapter.MenuAdapter;
import pe.com.maquistemas.basicproy.model.Plato;
import pe.com.maquistemas.basicproy.utilitario.Fecha;

public class ToolbarPersonalizadoActivity extends AppCompatActivity {
    public final static String KEY_TOOLBAR = "key_toolbar";
    LinearLayout layoutFactura,layoutBusqueda;
    MenuItem item_action_buscar;
    TextView txtFecha;
    boolean flag = false;
    Menu menu;
    ArrayList<Plato> platos;
    RecyclerView recyclerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_personalizado);
        setToolbar();
        inicializarObjetos();
        setRecyclerPlatos();

    }

    private void setRecyclerPlatos() {
        platos = new ArrayList<>();
        recyclerMenu = (RecyclerView)findViewById(R.id.recyclerMenu);
        recyclerMenu.setLayoutManager(new GridLayoutManager(this, 1));

        for(int i=0; i < 2; i++){

        }

        MenuAdapter menuAdapter = new MenuAdapter(platos);
        recyclerMenu.setAdapter(menuAdapter);

    }

    private void inicializarObjetos() {

        layoutFactura=findViewById(R.id.layoutFactura);
        layoutBusqueda=findViewById(R.id.layoutBusqueda);
        item_action_buscar = findViewById(R.id.action_buscar);
        txtFecha = findViewById(R.id.txtFecha);
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
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){


            case R.id.action_buscar:
                if(!this.flag){
                    layoutFactura.setVisibility(View.GONE);
                    layoutBusqueda.setVisibility(View.VISIBLE);
                    txtFecha.setText(Fecha.getFecha());
                    menu.getItem(5).setIcon(R.drawable.close18);
                    this.flag = !this.flag;
                    return true;
                }else {
                    layoutFactura.setVisibility(View.VISIBLE);
                    layoutBusqueda.setVisibility(View.GONE);
                    txtFecha.setText(Fecha.getFecha());
                    menu.getItem(5).setIcon(R.drawable.buscar_white);
                    this.flag = !this.flag;
                    return true;
                }


            default:
                return super.onOptionsItemSelected(item);



        }

    }
}
