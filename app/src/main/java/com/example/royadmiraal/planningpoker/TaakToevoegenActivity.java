package com.example.royadmiraal.planningpoker;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.royadmiraal.planningpoker.models.Sessie;


public class TaakToevoegenActivity extends AppCompatActivity {

    TextView invoerTaakNaam, invoerTaakOmschrijving;

    String invoerTaakNaamString, invoerTaakOmschrijvingString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toevoegen_taak);


    }

    public void toevoegenTaak (View view){

        Intent intent = new Intent(TaakToevoegenActivity.this, SessieEigenschappenActivity.class);


        invoerTaakNaam = (TextView) findViewById(R.id.naamTaakField);
        invoerTaakOmschrijving = (TextView) findViewById(R.id.omschrijvingTaakField);

        invoerTaakNaamString = invoerTaakNaam.getText().toString();
        invoerTaakOmschrijvingString = invoerTaakOmschrijving.getText().toString();

        Log.d("data", "testststststtstss");
        Log.d("Data", invoerTaakNaamString);
        Log.d("Data", invoerTaakOmschrijvingString);

        intent.putExtra("taakNaam", invoerTaakNaam.getText().toString());
        intent.putExtra("taakOmschrijving", invoerTaakOmschrijving.getText().toString());

        startActivity(intent);




    }
}