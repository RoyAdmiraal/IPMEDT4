package com.example.royadmiraal.planningpoker.models;

public class Gebruiker {
    private int id;
    private String naam;
    private int huidigeKaart;

    public int getHuidigeKaart() {
        return huidigeKaart;
    }

    public void setHuidigeKaart(int huidigeKaart) {
        this.huidigeKaart = huidigeKaart;
    }

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
}
