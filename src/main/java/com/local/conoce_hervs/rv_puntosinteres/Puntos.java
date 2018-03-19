package com.local.conoce_hervs.rv_puntosinteres;

import java.util.List;

public class Puntos {

    String nomPunto;
    int fotoPuntoId;

    public Puntos(String nomPunto, int fotoPuntoId) {
        this.nomPunto = nomPunto;
        this.fotoPuntoId = fotoPuntoId;
    }

    public Puntos(){}

    private List<Puntos> puntos;


    /*public void initializeData(){
        puntos = new ArrayList<>();
        puntos.add(new PuntosInteres( "Punto de Interes", R.drawable.hotelhervasej));

    }
    */



    public String getNomPunto() {
        return nomPunto;
    }

    public void setNomPunto(String nomPunto) {
        this.nomPunto = nomPunto;
    }

    public int getFotoPuntoId() {
        return fotoPuntoId;
    }

    public void setFotoPuntoId(int fotoPuntoId) {
        this.fotoPuntoId = fotoPuntoId;
    }





}
