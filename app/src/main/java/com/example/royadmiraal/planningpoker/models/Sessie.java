package com.example.royadmiraal.planningpoker.models;

import java.sql.Time;
import java.util.ArrayList;

public class Sessie {
    private int id;
    private String naam;
    private Time timer;
    private int scrumMasterId;
    private Object[][] gebruikerLijst = new Object[2][];
    private String persoonlijkeSpelerLijst;

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

    public Time getTimer() {
        return timer;
    }

    public void setTimer(Time timer) {
        this.timer = timer;
    }

    public int getScrumMasterId() {
        return scrumMasterId;
    }

    public void setScrumMasterId(int scrumMasterId) {
        this.scrumMasterId = scrumMasterId;
    }

    public Object[][] getGebruikerLijst() {
        return gebruikerLijst;
    }

    public void setGebruikerLijst(Object[][] gebruikerLijst) {
        this.gebruikerLijst = gebruikerLijst;
    }

    public String getPersoonlijkeSpelerLijst() {
        return persoonlijkeSpelerLijst;
    }

    public void setPersoonlijkeSpelerLijst(String persoonlijkeSpelerLijst) {
        this.persoonlijkeSpelerLijst = persoonlijkeSpelerLijst;
    }
}
