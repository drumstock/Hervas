package com.local.conoce_hervs.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ModelPuntos extends ArrayList<Parcelable> implements Parcelable {

    private String nombre;
    private String descripcion;
    private String mapa;
    private String foto;

    public ModelPuntos(String nombre, String descripcion, String mapa, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mapa = mapa;
        this.foto = foto;
    }

    protected ModelPuntos(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        mapa = in.readString();
        foto = in.readString();
    }

    public static final Creator<ModelPuntos> CREATOR = new Creator<ModelPuntos>() {
        @Override
        public ModelPuntos createFromParcel(Parcel in) {
            return new ModelPuntos(in);
        }

        @Override
        public ModelPuntos[] newArray(int size) {
            return new ModelPuntos[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {



            parcel.writeString(nombre);
            parcel.writeString(descripcion);
            //parcel.writeString(mapa);
            parcel.writeString(foto);


    }
}
