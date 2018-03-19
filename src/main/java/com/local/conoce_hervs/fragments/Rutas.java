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
import com.local.conoce_hervs.rv_rutas.AdaptadorRutas;
import com.local.conoce_hervs.rv_rutas.RutasRV;

import java.util.ArrayList;
import java.util.List;


public class Rutas extends Fragment {

    List<RutasRV> rutasRV = new ArrayList<>();
    RecyclerView rvRuta;
    AdaptadorRutas adapterRuts;
    Rutas rut;

    public Rutas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.restauracion_layout, container, false);

        rvRuta = view.findViewById(R.id.RVRutas);

        adapterRuts = new AdaptadorRutas(rutasRV);

        //Ésta subclase LayoutManager por defecto hará que tu RecyclerView parezca una ListView.
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvRuta.setLayoutManager(llm);

        rvRuta.setAdapter(adapterRuts);

        rellenarRutas();

        // Devolvemos la vista al fragment
        return view;

    }


    public void rellenarRutas() {

        rutasRV.add(new RutasRV("RUTA A", R.drawable.barrioj));

    }
}