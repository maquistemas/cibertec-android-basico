package pe.com.maquistemas.basicproy.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.adapter.CriollosTabAdapter;
import pe.com.maquistemas.basicproy.utilitario.Tag;


public class CriollosFragment extends Fragment {

    public CriollosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_criollos, container, false);

        //se reemplazó getFragmentManager() por getChildFragmentManager() en el constructor FragmentPagerAdapter (CriollosTabAdapter) del fragmento principal(CriolllosFragment)
        //ya que el anterior no mostraba los fragmentos hijos(AlmuerzoFragment y cenaFragment) al  salir y regresar
        CriollosTabAdapter criollosTabAdapter = new CriollosTabAdapter(getChildFragmentManager());
        ViewPager pager = (ViewPager)view.findViewById(R.id.viewPager);
        pager.setAdapter(criollosTabAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

}
