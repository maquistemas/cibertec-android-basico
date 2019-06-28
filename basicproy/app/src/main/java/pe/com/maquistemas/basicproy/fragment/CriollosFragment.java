package pe.com.maquistemas.basicproy.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.adapter.CriollosTabAdapter;


public class CriollosFragment extends Fragment {

    public CriollosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_criollos, container, false);
        CriollosTabAdapter criollosTabAdapter = new CriollosTabAdapter(getFragmentManager());
        ViewPager pager = (ViewPager)view.findViewById(R.id.viewPager);
        pager.setAdapter(criollosTabAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

}
