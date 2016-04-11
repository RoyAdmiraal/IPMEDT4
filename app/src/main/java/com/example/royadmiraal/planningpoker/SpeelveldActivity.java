package com.example.royadmiraal.planningpoker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Objects;


/**
 * Created by Royadmiraal on 04-04-16.
 */
public class SpeelveldActivity extends AppCompatActivity {

    String []  deelneemGegevens = {"naam","Sessie id"};
    String []  spelerLijst = {"speler 1","Speler 2", "Speler 3", "Speler 4", "Speler 5", "Speler 6", "Speler 7", "Speler 8"};
    ImageView plek1, plek2, plek3, plek4, plek5, plek6, plek7, plek8;
    int kaartNummer = 13;
    ImageAdapter adapter;

    public void opleggen(View view){

       // adapter.instantiateItem()
       // adapter.getItemPosition(Object);

        }





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speelveld);
        Intent intent = getIntent();
        deelneemGegevens = intent.getStringArrayExtra("strings");
        //spelerLijst[1] = deelneemGegevens[0];

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        createSpeelveld();

    }
    public void naamNaarDatabase(){

    }
    public void createSpeelveld(){


        Button opleggenKaart = (Button) findViewById(R.id.opleggenKaartButton);

        plek1 = (ImageView) findViewById(R.id.plek1);
        plek2 = (ImageView) findViewById(R.id.plek2);
        plek3 = (ImageView) findViewById(R.id.plek3);
        plek4 = (ImageView) findViewById(R.id.plek4);
        plek5 = (ImageView) findViewById(R.id.plek5);
        plek6 = (ImageView) findViewById(R.id.plek6);
        plek7 = (ImageView) findViewById(R.id.plek7);
        plek8 = (ImageView) findViewById(R.id.plek8);

        int[] kaartenLijst = new int[]{
                R.drawable.kaart0,                      // array 0 kaart  0
                R.drawable.kaart0_5,                    // array 1 kaart  0.5
                R.drawable.kaart1,                      // array 2 kaart  1
                R.drawable.kaart2,                      // array 3 kaart  2
                R.drawable.kaart3,                      // array 4 kaart  3
                R.drawable.kaart5,                      // array 5 kaart  5
                R.drawable.kaart8,                      // array 6 kaart  8
                R.drawable.kaart13,                     // array 7 kaart  13
                R.drawable.kaart20,                     // array 8 kaart  20
                R.drawable.kaart40,                     // array 9 kaart  40
                R.drawable.kaart100,                    // array 10 kaart 100
                R.drawable.kaartoneindig,               // array 11 kaart oneinding
                R.drawable.kaartvraagteken,             // array 12 kaart vraagteken
                R.drawable.kaartstandaart,              // array 13 kaart standaart
                R.drawable.kaartkoffie,                 // array 14 kaart koffie
                R.drawable.kaartachterkant,};           // array 15 kaart achterkant

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), kaartenLijst[kaartNummer]);
        plek1.setImageBitmap(bitmap);
        plek2.setImageBitmap(bitmap);
        plek3.setImageBitmap(bitmap);
        plek4.setImageBitmap(bitmap);
        plek5.setImageBitmap(bitmap);
        plek6.setImageBitmap(bitmap);
        plek7.setImageBitmap(bitmap);
        plek8.setImageBitmap(bitmap);



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
}