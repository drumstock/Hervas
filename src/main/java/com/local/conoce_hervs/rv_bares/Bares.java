package com.local.conoce_hervs.rv_bares;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 16/03/2018.
 */

public class Bares {

    String nomBar;
    int photoIdBar;

    public Bares(String nomBar, int photoIdBar) {
        this.nomBar = nomBar;
        this.photoIdBar = photoIdBar;
    }

    public Bares(){}

    public List<Bares> bares;


    public void initializeData(){
        bares = new ArrayList<>();
        //hotels.add(new Hoteles( "HOTEL HERVAS", R.drawable.hotelhervasej));
        //hotels.add(new Hoteles("Lavery Maiss", "25 years old", R.drawable.lavery));
        //hotels.add(new Hoteles("Lillie Watts", "35 years old", R.drawable.lillie));
    }

    public String getNomBar() {
        return nomBar;
    }

    public void setNomBar(String nomBar) {
        this.nomBar = nomBar;
    }

    public int getPhotoIdBar() {
        return photoIdBar;
    }

    public void setPhotoIdBar(int photoIdBar) {
        this.photoIdBar = photoIdBar;
    }

    public List<Bares> getBares() {
        return bares;
    }

    public void setBares(List<Bares> bares) {
        this.bares = bares;
    }
}
