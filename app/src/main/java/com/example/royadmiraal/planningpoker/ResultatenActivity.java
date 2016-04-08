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

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getResults(1);

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

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Resultaat 1 titel hier");
        adapter.addFrag(new TwoFragment(), "Resultaat 2 titel hier");
        adapter.addFrag(new ThreeFragment(), "Resultaat 3 titel hier");
        adapter.addFrag(new FourFragment(), "Resultaat 4 titel hier");
        adapter.addFrag(new FiveFragment(), "Resultaat 5 titel hier");
        adapter.addFrag(new SixFragment(), "Resultaat 6 titel hier");
        adapter.addFrag(new SevenFragment(), "Resultaat 7 titel hier");
        adapter.addFrag(new EightFragment(), "Resultaat 8 titel hier");
        adapter.addFrag(new NineFragment(), "Resultaat 9 titel hier");
        adapter.addFrag(new TenFragment(), "Resultaat 10 titel hier");
        viewPager.setAdapter(adapter);
    }

    public int getResults(int id) {
        this.gebruikerId = id;

        return 0;
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