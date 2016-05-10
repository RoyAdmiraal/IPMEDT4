package com.example.royadmiraal.planningpoker.models;

import java.util.ArrayList;

public class Taak {
    private int id;
    private String naam;
    private String beschrijving;
    private int resultaat;
    private String opmerking;
    private int ronde;
    private boolean kaartenTonen;
    private ArrayList gespeeldeKaartenlijst = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getResultaat() {
        return resultaat;
    }

    public void setResultaat(int resultaat) {
        this.resultaat = resultaat;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public int getRonde() {
        return ronde;
    }

    public void setRonde(int ronde) {
        this.ronde = ronde;
    }

    public boolean isKaartenTonen() {
        return kaartenTonen;
    }

    public void setKaartenTonen(boolean kaartenTonen) {
        this.kaartenTonen = kaartenTonen;
    }

    public ArrayList getGespeeldeKaartenlijst() {
        return gespeeldeKaartenlijst;
    }

    public void setGespeeldeKaartenlijst(ArrayList gespeeldeKaartenlijst) {
        this.gespeeldeKaartenlijst = gespeeldeKaartenlijst;
    }
}
