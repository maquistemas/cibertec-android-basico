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

import java.util.stream.Collectors;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.adapter.AlmuerzoAdapter;
import pe.com.maquistemas.basicproy.model.Plato;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlmuerzoFragment extends Fragment {

    RecyclerView recyclerView;
    AlmuerzoAdapter almuerzoAdapter;



    public AlmuerzoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_almuerzo, container, false);
    }


    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvAlmuerzo);
//                          recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        almuerzoAdapter = new AlmuerzoAdapter(Plato.getPlatos(1), getActivity());
        recyclerView.setAdapter(almuerzoAdapter);


    }




}
