package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class DeelnemenActivity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deelnemen);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void deelnemenSpeelveld(View view) {
        Intent intent = new Intent(DeelnemenActivity.this, SpeelveldActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_help:

                Intent intent = new Intent(this, HelpActivity.class);
                startActivity(intent);

                return true;
            default:
                return true;
        }
    }

    public void doorgaanSpeelveld(View view){
        EditText sessieId = (EditText)findViewById(R.id.privateKey);


        //Intent intent = new Intent(DeelnemenActivity.this, SpeelveldActivity.class);
        //String[] deelneemGegevens = new String[] {invoerNaam.getText().toString(),sessieId.getText().toString() };
        //intent.putExtra("strings", deelneemGegevens);
        //startActivity(intent);


        Log.d("invoerNaam", "naam wordt geregistreerd");
        Log.d("SessieId", "PIN komt door");

        startActivity(new Intent(DeelnemenActivity.this, SpeelveldActivity.class));
    }



}
