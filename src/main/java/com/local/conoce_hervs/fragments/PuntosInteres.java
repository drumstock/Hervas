package com.local.conoce_hervs.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.local.conoce_hervs.R;
import com.local.conoce_hervs.rv_puntosinteres.AdaptadorInteres;
import com.local.conoce_hervs.rv_puntosinteres.Puntos;

import java.util.ArrayList;
import java.util.List;


public class PuntosInteres extends Fragment {

    List<Puntos> puntosint = new ArrayList<>();
    RecyclerView rvpuntos;
    AdaptadorInteres adapterpuntos;
    PuntosInteres pint;

    public PuntosInteres() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.puntosinteres_layout, container, false);


        rvpuntos = v.findViewById(R.id.RVinteres);

        adapterpuntos = new AdaptadorInteres(puntosint);

        //Ésta subclase LayoutManager por defecto hará que tu RecyclerView parezca una ListView.
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvpuntos.setLayoutManager(llm);

        rvpuntos.setAdapter(adapterpuntos);

        rellenarPuntos();

        // Devolvemos la vista al fragment
        return v;

    }


    public void rellenarPuntos() {

        puntosint.add(new Puntos("Punto de Interes", R.mipmap.ic_launcher));

    }
}