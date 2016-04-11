package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AanmakenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aanmaken);
        //createUser();
        createSessie();
    }

    private void createSessie() {

        //aanmaken in database dmv api

        // object mee geven aan sessie eigenschappen
    }

    public void doorgaanSessieEigenschappen(View view) {
        Intent intent = new Intent(AanmakenActivity.this, SessieEigenschappenActivity.class);
        startActivity(intent);
    }


}

