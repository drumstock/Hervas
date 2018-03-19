package com.local.conoce_hervs.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.local.conoce_hervs.R;

import com.local.conoce_hervs.db_alojamientos.ModelAlojamiento;
import com.local.conoce_hervs.db_alojamientos.UtilidadesDB;
import com.local.conoce_hervs.rv_hoteles.AdaptadorHotel;



import java.util.ArrayList;
import java.util.List;

public class Alojamiento extends Fragment {

    List<ModelAlojamiento> hotels  = new ArrayList<>();
    RecyclerView rv;
    AdaptadorHotel adapter;

    public Alojamiento(){
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.alojamiento_layout, container, false);


        rv = view.findViewById(R.id.RVHoteles);

       // adapter = new AdaptadorHotel(hotels);

        //Ésta subclase LayoutManager por defecto hará que tu RecyclerView parezca una ListView.
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        //rv.setAdapter(adapter);


        rellenaad(rv);

        // Devolvemos la vista al fragment
        return view;

    }


    /*public void rellenarHoteles(){

        hotels.add(new ModelAlojamiento( "Hotel Hervás", R.mipmap.ic_launcher));

    }
*/
    public void rellenaad(RecyclerView rv){

        //DBAlojamientos listaH=new DBAlojamientos(getActivity());
        UtilidadesDB listaHoteles = new UtilidadesDB(getActivity());
        Cursor cur = listaHoteles.listarAlojamiento();

        if (cur != null){
            // Si esta vacia la lista
        }else{
            if (cur.moveToFirst()) {
                do {
                    hotels.add( new ModelAlojamiento(cur.getString(1), cur.getString(2), cur.getString(3), cur.getString(4)));
                } while (cur.moveToNext());
            }
        }


        adapter = new AdaptadorHotel(hotels);
        rv.setAdapter(adapter);

        listaHoteles.close();


    }

}