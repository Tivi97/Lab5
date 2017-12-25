package com.example.algoritm.lab5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    class TabAdapter extends FragmentPagerAdapter {

        TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position) {
                case 0:
                    title = "Отели";
                    break;
                case 1:
                    title = "Музеи";
                    break;

            }
            return title;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new HotelFragment();
                    break;
                case 1:
                    fragment = new MuseumFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
