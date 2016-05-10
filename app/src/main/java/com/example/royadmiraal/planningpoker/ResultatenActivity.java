package com.example.royadmiraal.planningpoker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.royadmiraal.planningpoker.fragments.EightFragment;
import com.example.royadmiraal.planningpoker.fragments.FiveFragment;
import com.example.royadmiraal.planningpoker.fragments.FourFragment;
import com.example.royadmiraal.planningpoker.fragments.NineFragment;
import com.example.royadmiraal.planningpoker.fragments.OneFragment;
import com.example.royadmiraal.planningpoker.fragments.SevenFragment;
import com.example.royadmiraal.planningpoker.fragments.SixFragment;
import com.example.royadmiraal.planningpoker.fragments.TenFragment;
import com.example.royadmiraal.planningpoker.fragments.ThreeFragment;
import com.example.royadmiraal.planningpoker.fragments.TwoFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultatenActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private String getResultatenUrl = "http://collinwoerde.nl/ipmedt4/getResultaten.php";


    private int gebruikerId;
    private int[] sessies;
    private String[] resultaten;

    private int aantalSessieResultaten = 2;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Object results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestQueue = Volley.newRequestQueue(getApplicationContext());


        setGebruikerId(1);
        setResults();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultaten);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setGebruikerId(int id) {
        this.gebruikerId = id;
    }

    private void setResults() {
        //getResults();
        getTest();
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Final sprint april");
        adapter.addFrag(new TwoFragment(), "Sprint 2 april test");
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

    public Object getResults() {
        Log.d("Log data: SessieId", "test");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, getResultatenUrl, (String) null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {


                    JSONArray sessies = response.getJSONArray("sessies");
                    Log.d("Log data: SessieId", "emv orimoierm");
                    for (int i = 0; i < sessies.length(); i++) {
                        JSONObject sessie = sessies.getJSONObject(i);
                        String sessieId = sessie.getString("gbr_sessie_sessie_id");

                        Log.d("Log data: SessieId", sessieId);
                    }

                } catch (Exception e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Log data: ", error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);


        return results;
    }

    public void getTest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, getResultatenUrl, (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray sessies = response.getJSONArray("sessies");

                    for (int i = 0; i < sessies.length(); i++) {
                        JSONObject sessie = sessies.getJSONObject(i);

                        String sessieId = sessie.getString("gbr_sessie_sessie_id");

                        Log.d("Log data: ", sessieId);
                    }
                } catch (Exception e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Log data: ", error.toString());
            }
        });

        Log.d("Is deze NULL ??? "," Ermm .. Dus : "+requestQueue);
        requestQueue.add(jsonObjectRequest);
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
            return aantalSessieResultaten;
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