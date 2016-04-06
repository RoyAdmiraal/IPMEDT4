package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DeelnemenActivity extends AppCompatActivity {

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

    public void doorgaanSpeelveld(View view) {

        EditText invoerNaam = (EditText)findViewById(R.id.invoerNaam);
        EditText privateKey = (EditText)findViewById(R.id.privateKey);

        Intent intent = new Intent(DeelnemenActivity.this, SpeelveldActivity.class);
        intent.putExtra("invoerNaam", invoerNaam.getText().toString());
        intent.putExtra("privateKey", privateKey.getText().toString());

        Log.d("invoerNaam", "naam wordt geregistreerd");
        Log.d("privateKey", "PIN komt door");

        startActivity(new Intent(DeelnemenActivity.this, SpeelveldActivity.class));
    }
}