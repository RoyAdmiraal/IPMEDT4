package com.example.royadmiraal.planningpoker.fragments;

/**
 * Created by Collin on 7-4-2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.royadmiraal.planningpoker.R;

//import info.androidhive.materialtabs.R;


public class NineFragment extends Fragment{

    public NineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nine, container, false);
    }

}
