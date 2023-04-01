package natalia.pratica06.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import natalia.pratica06.R;
import natalia.pratica06.Tab1Cadastrar;
import natalia.pratica06.Tab2Listar;
import natalia.pratica06.Tab3Atualizar;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1Cadastrar tab1Cadastrar = new Tab1Cadastrar();
                return tab1Cadastrar;
            case 1:
                Tab2Listar tab2Listar = new Tab2Listar();
                return tab2Listar;
            case 2:
                Tab3Atualizar tab3Atualizar = new Tab3Atualizar();
                return tab3Atualizar;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}