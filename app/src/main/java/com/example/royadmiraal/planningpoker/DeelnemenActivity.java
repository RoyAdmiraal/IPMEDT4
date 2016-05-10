package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class DeelnemenActivity extends AppCompatActivity{


    private RequestQueue requestQueue;
    private String getResultatenUrl = "http://collinwoerde.nl/ipmedt4/getResultaten.php";
    private Object results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deelnemen);


    }

    public Object getResults() {
        Log.d("Log data: SessieId", "test");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, getResultatenUrl, (String) null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray sessies = response.getJSONArray("sessies");

                    for (int i = 0; i < sessies.length(); i++) {
                        JSONObject sessie = sessies.getJSONObject(i);
                        String sessieId = sessie.getString("gbr_sessie_sessie_id");
                    }

                } catch (Exception e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Log data: ", error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);


        return results;
    }

    public void getTest() {
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
                } catch (Exception e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Log data: ", error.toString());
            }
        });

        Log.d("Is deze NULL ??? ", " Ermm .. Dus : " + requestQueue);
        requestQueue.add(jsonObjectRequest);
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
