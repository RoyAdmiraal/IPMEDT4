package com.example.royadmiraal.planningpoker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SpeelveldActivity extends AppCompatActivity {
    private static final String DEFAULT = "n/a";
    private String[] deelneemGegevens = {"naam", "Sessie id"};
    public boolean toonKaarten = false; //TODO op true door scrum master of als de timer is afgelopen
    private String[] spelerLijst = {"S.M. hier", "Speler 2", "Speler 3", "Speler 4", "Speler 5", "Speler 6", "Speler 7", "Speler 8"};
    private int[] tempKaartenLijstSpelers = {14, 14, 14, 14, 14, 14, 14, 14};
    private int[] kaartenLijstSpelers = {14, 14, 14, 14, 14, 14, 14, 14};
    ImageView plek1, plek2, plek3, plek4, plek5, plek6, plek7, plek8;
    ImageAdapter adapter;
    TextView taakOmschrijving;
    public int selectedCard;
    //TextView huidigeKaartNaam;

    private void setNaam() {
        Log.d("log data: ", "ophalen naam");
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("gebruiker_naam", DEFAULT);
        Log.d("log data: ", name);
        spelerLijst[1] = name;
    }

    private void getKaartenDatabase() {


        Log.d("Log data: ", "haalt nu op uit db");


        //for (int i = 0; i < kaartenLijstSpelers.length; i++) {
        //    kaartenLijstSpelers[i] = kaartenLijstSpelers[i]; //TODO de Json array in kaartenlijst zetten (dit ook elke 5 sec aanroepen)
        //}


        toonSpeelveld();
    }

    public void opleggen(View view) {
        kaartenLijstSpelers[1] = selectedCard;
        toonSpeelveld();
    }

    private void setKaarten() {
        // LOOP de hele kaarten ARRAY en SET als er een kaart is opgelegd
        for (int i = 0; i < kaartenLijstSpelers.length; i++) {
            if (kaartenLijstSpelers[i] != 16 && kaartenLijstSpelers[i] != 14) {
                tempKaartenLijstSpelers[i] = 15;
            } else {
                if (kaartenLijstSpelers[i] != 16) {
                    tempKaartenLijstSpelers[i] = 14;
                } else {
                    tempKaartenLijstSpelers[i] = 16;
                }
            }
        }
    }

    private void toonSpeelveld() {
        setKaarten();
        if (toonKaarten) {
            //Log.d("Log data: ", "toonKaarten true");
            createSpeelveld(kaartenLijstSpelers);
        } else {
            //Log.d("Log data: ", "toonKaarten false");
            createSpeelveld(tempKaartenLijstSpelers);
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speelveld);
        //Intent intent = getIntent();
        //deelneemGegevens = intent.getStringArrayExtra("strings");
        //spelerLijst[1] = deelneemGegevens[0];

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        setNaam();
       // ophalenTaak();


        // Een listener voor het ophalen van de geselceteerde kaart
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int cardNumber) {
                selectedCard = cardNumber;

                huidigeKaart();
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        getKaartenDatabase();
    }

    private void huidigeKaart() {

        TextView huidigeKaartNaam = (TextView) findViewById(R.id.huidigeKaart);
        // huidigeKaartNaam.findViewById(R.id.huidigeKaart);
        huidigeKaartNaam.setText((selectedCard + 1) + "/14");

    }

    public void createSpeelveld(int[] kaartenLijstSpelers) {
        plek1 = (ImageView) findViewById(R.id.plek1);
        plek2 = (ImageView) findViewById(R.id.plek2);
        plek3 = (ImageView) findViewById(R.id.plek3);
        plek4 = (ImageView) findViewById(R.id.plek4);
        plek5 = (ImageView) findViewById(R.id.plek5);
        plek6 = (ImageView) findViewById(R.id.plek6);
        plek7 = (ImageView) findViewById(R.id.plek7);
        plek8 = (ImageView) findViewById(R.id.plek8);

        int[] kaartenLijst = new int[]{
                R.drawable.kaart0,                      // array nr. 0 = kaart  0
                R.drawable.kaart0_5,                    // array nr. 1 = kaart  0.5
                R.drawable.kaart1,                      // array nr. 2 = kaart  1
                R.drawable.kaart2,                      // array nr. 3 = kaart  2
                R.drawable.kaart3,                      // array nr. 4 = kaart  3
                R.drawable.kaart5,                      // array nr. 5 = kaart  5
                R.drawable.kaart8,                      // array nr. 6 = kaart  8
                R.drawable.kaart13,                     // array nr. 7 = kaart  13
                R.drawable.kaart20,                     // array nr. 8 = kaart  20
                R.drawable.kaart40,                     // array nr. 9 = kaart  40
                R.drawable.kaart100,                    // array nr. 10 = kaart 100
                R.drawable.kaart_inf,                   // array nr. 11 = kaart oneindig
                R.drawable.kaart_vraag,                 // array nr. 12 = kaart vraagteken
                R.drawable.kaart_koffie,                // array nr. 13 = kaart koffie
                R.drawable.kaart_standaart,             // array nr. 14 = kaart standaart (grijs)
                R.drawable.kaart_achterkant,            // array nr. 15 = kaart achterkant (opgelegd)
                R.drawable.kaart_leeg                   // array nr. 16 = kaart leeg
        };

        Bitmap bitmap;

        for (int i = 0; i < kaartenLijstSpelers.length; i++) {
            bitmap = BitmapFactory.decodeResource(getResources(), kaartenLijst[kaartenLijstSpelers[i]]);

            switch (i) {
                case 0:
                    plek1.setImageBitmap(bitmap);
                    break;
                case 1:
                    plek2.setImageBitmap(bitmap);
                    break;
                case 2:
                    plek3.setImageBitmap(bitmap);
                    break;
                case 3:
                    plek4.setImageBitmap(bitmap);
                    break;
                case 4:
                    plek5.setImageBitmap(bitmap);
                    break;
                case 5:
                    plek6.setImageBitmap(bitmap);
                    break;
                case 6:
                    plek7.setImageBitmap(bitmap);
                    break;
                case 7:
                    plek8.setImageBitmap(bitmap);
                    break;
                default:
                    Log.d("Log data: ", "Lege array...");
                    plek1.setImageBitmap(bitmap);
                    plek2.setImageBitmap(bitmap);
                    plek3.setImageBitmap(bitmap);
                    plek4.setImageBitmap(bitmap);
                    plek5.setImageBitmap(bitmap);
                    plek6.setImageBitmap(bitmap);
                    plek7.setImageBitmap(bitmap);
                    plek8.setImageBitmap(bitmap);
            }
        }

        TextView spelerNaam1 = (TextView) findViewById(R.id.spelerNaam1);
        TextView spelerNaam2 = (TextView) findViewById(R.id.spelerNaam2);
        TextView spelerNaam3 = (TextView) findViewById(R.id.spelerNaam3);
        TextView spelerNaam4 = (TextView) findViewById(R.id.spelerNaam4);
        TextView spelerNaam5 = (TextView) findViewById(R.id.spelerNaam5);
        TextView spelerNaam6 = (TextView) findViewById(R.id.spelerNaam6);
        TextView spelerNaam7 = (TextView) findViewById(R.id.spelerNaam7);
        TextView spelerNaam8 = (TextView) findViewById(R.id.spelerNaam8);

        String print = "";
        for (String s : spelerLijst) {
            print += s;
        }
        spelerNaam1.setText(spelerLijst[0]);
        spelerNaam2.setText(spelerLijst[1]);
        spelerNaam3.setText(spelerLijst[2]);
        spelerNaam4.setText(spelerLijst[3]);
        spelerNaam5.setText(spelerLijst[4]);
        spelerNaam6.setText(spelerLijst[5]);
        spelerNaam7.setText(spelerLijst[6]);
        spelerNaam8.setText(spelerLijst[7]);


    }
/*
    private void ophalenTaak() {
        SharedPreferences sharedPreferences = getSharedPreferences("TaakData", Context.MODE_PRIVATE);
        String naam = sharedPreferences.getString("taak_naam", DEFAULT);
        String beschrijving = sharedPreferences.getString("taak_beschrijving", DEFAULT);


        Log.d("data", naam);
        Log.d("data", beschrijving);


        if(naam.equals(DEFAULT)){
            Toast.makeText(this, "Taak niet geladen", Toast.LENGTH_LONG).show();
        } else {
            taakOmschrijving.setText(naam + "/n" +beschrijving);
        }
    }*/

}