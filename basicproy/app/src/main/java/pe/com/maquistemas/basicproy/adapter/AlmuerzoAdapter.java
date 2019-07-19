package pe.com.maquistemas.basicproy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.model.Plato;

public class AlmuerzoAdapter extends RecyclerView.Adapter<AlmuerzoAdapter.ViewHolder> {

    final String TAG = "AlmuerzoAdapter";
    List<Plato> platos = new ArrayList<Plato>();
    Context context;

    public AlmuerzoAdapter(List<Plato> platos, Context context) {
        this.platos = platos;
        this.context = context;
    }

    @Override
    public AlmuerzoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_platos, parent, false);
        return new AlmuerzoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlmuerzoAdapter.ViewHolder holder, int position) {
        Plato p = platos.get(position);

        holder.nombrePlato.setText(p.getNombre());

        Glide.with(context)
                .load(getImage(p.getFoto()) )
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoPlato);

    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoPlato;
        TextView nombrePlato;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoPlato = itemView.findViewById(R.id.fotoPlato);

            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(300,300);
            fotoPlato.setLayoutParams(parms);

            nombrePlato = itemView.findViewById(R.id.nombrePlato);
        }
    }


    //obtener imagen desde la ruta drawable
    public int getImage(String imageName) {

        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        return drawableResourceId;
    }

}
