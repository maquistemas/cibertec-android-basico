package pe.com.maquistemas.basicproy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.com.maquistemas.basicproy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlmuerzoFragment extends Fragment {


    public AlmuerzoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_almuerzo, container, false);
    }

}
