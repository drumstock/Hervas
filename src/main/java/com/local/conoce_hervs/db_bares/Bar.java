package com.local.conoce_hervs.db_bares;



import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Bar extends Object{

   public static List<String> nombreBares = new ArrayList<>();
   public static List<String> descripBares = new ArrayList<>();
   public static List<String> localizBares = new ArrayList<>();
   public static List<String> linksBares = new ArrayList<>();
   public static List<String> fotosBares = new ArrayList<>();


   private static final Bar INSTANCIABAR = new Bar();

    //constructor
    public Bar(){}

    //getters y setters

    public static Bar getInstance(){
        return INSTANCIABAR;
    }

    public static List<String> obtenerListaNombresBares(){
        return nombreBares;
    }

    public static List<String> obtenerListaDescripBares(){
        return descripBares;
    }

    public static List<String> obtenerListaLocBares(){
        return localizBares;
    }

    public static List<String> obtenerListaLinksBares(){
        return linksBares;
    }

    public static List<String> obtenerFotosBares() {
        return fotosBares;
    }

    public void setearValoresBares(String nomBar, String desBar, String locBar, String linkBar,
                                   String fotBar){

        nombreBares.add(nomBar);
        descripBares.add(desBar);
        localizBares.add(locBar);
        linksBares.add(linkBar);
        fotosBares.add(fotBar);


    }
}
