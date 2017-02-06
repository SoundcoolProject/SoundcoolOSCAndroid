package org.soundcool.upv.oscapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;




/**
 * Created by jaiserpe on 21/01/2016.
 */
public class OtraActividad extends AppCompatActivity {

    //private Toolbar toolbar;
    private TabLayout tabLayout;
    private NoSwipeViewPager viewPager; // Declarar usando la clase customizada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otra_actividad_main);

        /* No quiero Action Bar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */

        viewPager = (NoSwipeViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setPagingEnabled(false);  // Aqui deshabilito el "swiping"

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_tab_settings);  // cargo icono de settings

        // Hacemos la pantalla siempre activa en esta actividad sólo (la de las pestañas)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Player/Effect"); // el orden de las pestañas ha ido cambiando
        adapter.addFragment(new FourFragment(), "Sampler");
        adapter.addFragment(new ThreeFragment(), "Keyboard");
        adapter.addFragment(new FiveFragment(), "Envelope");
        adapter.addFragment(new TwoFragment(), "Mixer");
        adapter.addFragment(new BackToSettingsFragment(), "");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
