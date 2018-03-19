package com.local.conoce_hervs.fragments;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.local.conoce_hervs.R;
import com.local.conoce_hervs.db_bares.Bar;
import com.local.conoce_hervs.db_bares.DatabaseBares;
import com.local.conoce_hervs.rv_bares.AdaptadorBares;
import com.local.conoce_hervs.rv_bares.Bares;

import java.util.ArrayList;
import java.util.List;


public class Restauracion extends Fragment {

    List<Bar> bares = new ArrayList<>();
    RecyclerView rvBar;
    AdaptadorBares adapterBar;
    DatabaseBares dbBares;

    public Restauracion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.restauracion_layout, container, false);

        rvBar = view.findViewById(R.id.RVbares);
        dbBares = new DatabaseBares(getActivity());
        dbBares = DatabaseBares.instance(getActivity());

        adapterBar = new AdaptadorBares(bares);

        if(dbBares!=null){
            Log. d("BASE DE DATOS","Si ha copiado la base");
        }

        Cursor cursor = DatabaseBares.select("SELECT * FROM restaurantes");
                                   //"SELECT * FROM Restaurantes ORDER BY Id ASC"

        while (cursor.moveToNext()){

            Bar.getInstance().setearValoresBares(cursor.getString(cursor.getColumnIndex("Nombre")),
                    cursor.getString(cursor.getColumnIndex("Descripción")),
                    cursor.getString(cursor.getColumnIndex("Localización")),
                    cursor.getString(cursor.getColumnIndex("Link")),
                            cursor.getString(cursor.getColumnIndex("Foto")));

        }

        dbBares.close();




        //Ésta subclase LayoutManager por defecto hará que tu RecyclerView parezca una ListView.
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvBar.setLayoutManager(llm);

        rvBar.setAdapter(adapterBar);

        //rellenarBares();

        // Devolvemos la vista al fragment
        return view;



    }


   /* public void rellenarBares() {

        bares.add(new Bares("Bar Hervás" +
                "", R.mipmap.ic_launcher));

    }*/


}
