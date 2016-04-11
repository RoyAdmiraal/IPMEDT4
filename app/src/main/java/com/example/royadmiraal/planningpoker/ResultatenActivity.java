package com.example.royadmiraal.planningpoker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ResultatenActivity extends AppCompatActivity {

    private int gebruikerId;
    private int[] sessies;
    private String[] resultaten;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setGebruikerId(1);
        setResults();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultaten);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setGebruikerId(int id) {
        this.gebruikerId = id;
    }

    private void setResults() {


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Taak 2");
        adapter.addFrag(new TwoFragment(), "Taak 1");
        adapter.addFrag(new ThreeFragment(), "");
        adapter.addFrag(new FourFragment(), "");
        adapter.addFrag(new FiveFragment(), "");
        adapter.addFrag(new SixFragment(), "");
        adapter.addFrag(new SevenFragment(), "");
        adapter.addFrag(new EightFragment(), "");
        adapter.addFrag(new NineFragment(), "");
        adapter.addFrag(new TenFragment(), "");
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

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}