package pe.com.maquistemas.basicproy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    ArrayList<Plato> platos;

    public MenuAdapter(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_platos,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder viewHolder, int i) {
//        viewHolder.asignarDatos(platos.get(i));
        Plato plato = platos.get(i);
        viewHolder.nombrePlato.setText(plato.getNombre());


        viewHolder.fotoPlato.setImageResource(R.drawable.arrozpollo);

    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoPlato;
        TextView nombrePlato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoPlato = itemView.findViewById(R.id.fotoPlato);
            nombrePlato = itemView.findViewById(R.id.nombrePlato);
        }

//        public void asignarDatos(Plato plato) {
//            platos.add(plato);
//        }
    }
}
