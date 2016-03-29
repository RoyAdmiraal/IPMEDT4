package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
