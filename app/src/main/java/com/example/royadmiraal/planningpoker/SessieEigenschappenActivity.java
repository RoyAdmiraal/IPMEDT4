package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class SessieEigenschappenActivity extends AppCompatActivity {


    private  EditText taakNaam1, taakOmschrijving1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessie_eigenschappen);


        taakNaam1 = (EditText) findViewById(R.id.taakNaam1);
        taakOmschrijving1 = (EditText) findViewById(R.id.omschrijvingTaak1);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SessieEigenschappenActivity.this, TaakToevoegenActivity.class);
                startActivity(intent);


            }
        });

        Intent i = getIntent();

        Bundle b = getIntent().getExtras();

        if (b != null) {
            String invoerTaakNaamString = i.getStringExtra("taakNaam");
            String invoerTaakOmschrijvingString = i.getStringExtra("taakOmschrijving");


            taakNaam1.setText(invoerTaakNaamString.toString());
            taakOmschrijving1.setText(invoerTaakOmschrijvingString.toString());
        }


    }

    public void doorgaanSpeelveld (View view){

        Intent intent = new Intent(SessieEigenschappenActivity.this, SpeelveldScrummasterActivity.class);
        startActivity(intent);

    }
}





