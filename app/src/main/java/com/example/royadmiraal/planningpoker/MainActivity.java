package com.example.royadmiraal.planningpoker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String DEFAULT = "N/A";
    private int volgendeId = 1;
    private String gebruikerNaam;
    TextView welkom;

    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welkom = (TextView) findViewById(R.id.txtWelkom);

        ophalenNaam();
    }

    public void toonNaamDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.activity_account, null);
        final EditText gebruiker_naam = (EditText) alertLayout.findViewById(R.id.gebruiker_naam);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("U eerste keer Planning Poker!");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setPositiveButton("Opslaan", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                gebruikerNaam = gebruiker_naam.getText().toString();
                //TODO kijken in db welke gebruiker_id hij krijgt
                welkom.setText("Welkom bij de Planning Poker app " + gebruikerNaam + "!");
                opslaanNaam();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }

    private void ophalenNaam() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("gebruiker_naam", DEFAULT);
        if(name.equals(DEFAULT)){
            toonNaamDialog();
        } else {
            welkom.setText("Welkom bij de Planning Poker app " + name + "!");
        }
    }

    private void opslaanNaam() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("gebruiker_id", volgendeId);
        editor.putString("gebruiker_naam", gebruikerNaam);
        editor.commit();

        Toast.makeText(this, "Naam succesvol opgeslagen!", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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

    public void aanmakenSessie(View view) {
        Intent intent = new Intent(MainActivity.this, AanmakenActivity.class);
        startActivity(intent);
    }

    public void deelnemenSessie(View view) {
        Intent intent = new Intent(MainActivity.this, DeelnemenActivity.class);
        startActivity(intent);
    }

    public void resultaten(View view) {
        Intent intent = new Intent(MainActivity.this, ResultatenActivity.class);
        startActivity(intent);
    }

}
