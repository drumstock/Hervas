
package com.local.conoce_hervs.rv_rutas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 16/03/2018.
 */

public class RutasRV {

    String nomRuta;
    int photoIdRuta;

    public RutasRV(String nomRuta, int photoIdRuta) {
        this.nomRuta = nomRuta;
        this.photoIdRuta = photoIdRuta;
    }

    public RutasRV(){}

    public List<RutasRV> rutasRV;


    public void initializeData(){
        rutasRV = new ArrayList<>();
        //hotels.add(new Hoteles( "HOTEL HERVAS", R.drawable.hotelhervasej));
        //hotels.add(new Hoteles("Lavery Maiss", "25 years old", R.drawable.lavery));
        //hotels.add(new Hoteles("Lillie Watts", "35 years old", R.drawable.lillie));
    }
}