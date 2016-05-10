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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultatenActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    //private String getResultatenUrl = "http://collinwoerde.nl/ipmedt4/getResultaten.php";
    private String getResultatenUrl = "http://192.168.141.1/ipmedt4/getResultaten.php";


    private int gebruikerId;
    private int[] sessies;
    private String[] resultaten;

    private int aantalSessieResultaten = 2;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Object results;

    private String sessieNaam1;
    private String sessieNaam2;
    private String sessieNaam3;
    private String sessieNaam4;
    private String sessieNaam5;
    private String sessieNaam6;
    private String sessieNaam7;
    private String sessieNaam8;
    private String sessieNaam9;
    private String sessieNaam10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gebruikerId = MainActivity.gebruiker.getId();

        Log.d("Log data: ", "GebruikerId: "+gebruikerId+"");

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        setGebruikerId(1);
        getResults();

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

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Final sprint april");
        adapter.addFrag(new TwoFragment(), "Sprint 2 april test");
        adapter.addFrag(new ThreeFragment(), sessieNaam3);
        adapter.addFrag(new FourFragment(), sessieNaam4);
        adapter.addFrag(new FiveFragment(), sessieNaam5);
        adapter.addFrag(new SixFragment(), sessieNaam6);
        adapter.addFrag(new SevenFragment(), sessieNaam7);
        adapter.addFrag(new EightFragment(), sessieNaam8);
        adapter.addFrag(new NineFragment(), sessieNaam9);
        adapter.addFrag(new TenFragment(), sessieNaam10);

        viewPager.setAdapter(adapter);
    }

    public Object getResults() {
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

                    JSONArray JSresultaat = response.getJSONArray("resultaat");

                    //aantalSessieResultaten = JSresultaat.length();


                    for (int i = 0; i < JSresultaat.length(); i++) {
                        JSONObject resultaat = JSresultaat.getJSONObject(i);

                        String naamSessieTest = resultaat.getString("sessie_naam");

                        Log.d("Log data: ", naamSessieTest);

                        switch (i) {
                            case 0:
                                sessieNaam1 = "Final sprint april";
                                //sessieNaam1 = resultaat.getString("sessie_naam");
                                break;
                            case 1:
                                sessieNaam2 = "Sprint 2 april test";
                                //sessieNaam2 = resultaat.getString("sessie_naam");
                                break;
                            case 2:
                                sessieNaam3 = resultaat.getString("sessie_naam");
                                break;
                            case 3:
                                sessieNaam4 = resultaat.getString("sessie_naam");
                                break;
                            case 4:
                                sessieNaam5 = resultaat.getString("sessie_naam");
                                break;
                            case 5:
                                sessieNaam6 = resultaat.getString("sessie_naam");
                                break;
                            case 6:
                                sessieNaam7 = resultaat.getString("sessie_naam");
                                break;
                            case 7:
                                sessieNaam8 = resultaat.getString("sessie_naam");
                                break;
                            case 8:
                                sessieNaam9 = resultaat.getString("sessie_naam");
                                break;
                            case 9:
                                sessieNaam10 = resultaat.getString("sessie_naam");
                                break;
                            default:
                                Log.d("Log data: ", "Wut");
                        }
                    }


                } catch (Exception e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Log data: ", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("gebruikerId", 1+"");
                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);

        return results;

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