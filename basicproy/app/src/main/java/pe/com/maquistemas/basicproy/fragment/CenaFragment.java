package pe.com.maquistemas.basicproy.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.adapter.AlmuerzoAdapter;
import pe.com.maquistemas.basicproy.model.Plato;


public class CenaFragment extends Fragment {

    RecyclerView recyclerView;
    AlmuerzoAdapter almuerzoAdapter;


    public CenaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cena, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvCena);
//                          recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        almuerzoAdapter = new AlmuerzoAdapter(Plato.getPlatos(2), getActivity());
        recyclerView.setAdapter(almuerzoAdapter);
    }
}
