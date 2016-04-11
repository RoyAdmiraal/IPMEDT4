package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.royadmiraal.planningpoker.models.Sessie;


public class SessieEigenschappenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessie_eigenschappen);
    }

    public void doorgaanSpeelveld(View view) {
        Intent intent = new Intent(SessieEigenschappenActivity.this, SpeelveldActivity.class);
        startActivity(intent);
    }
}