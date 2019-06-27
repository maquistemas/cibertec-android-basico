package pe.com.maquistemas.basicproy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pe.com.maquistemas.basicproy.fragment.AlmuerzoFragment;
import pe.com.maquistemas.basicproy.fragment.CenaFragment;

public class CriollosTabAdapter extends FragmentPagerAdapter {
    final static int numberOfTabs = 2;

    public CriollosTabAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new AlmuerzoFragment();
            case 1:
                return  new CenaFragment();
        }

        return new AlmuerzoFragment();
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Almuerzo";
            case 1:
                return "Cena";
        }
        return null;
    }
}
