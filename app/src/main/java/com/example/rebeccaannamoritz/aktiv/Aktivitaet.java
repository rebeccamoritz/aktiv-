package com.example.rebeccaannamoritz.aktiv;

/**
 * Created by rebeccaannamoritz on 19.10.15.
 */
public class Aktivitaet {

    String id;
    String name;
    Double lat;
    Double longi;
    String beschreibung;
    String link;
    Integer sonnig;
    Integer leicht_bewoelkt;
    Integer wolkig;
    Integer bedeckt;
    Integer nebel;
    Integer spruehregen;
    Integer regen;
    Integer schnee;
    Integer schauer;
    Integer gewitter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}