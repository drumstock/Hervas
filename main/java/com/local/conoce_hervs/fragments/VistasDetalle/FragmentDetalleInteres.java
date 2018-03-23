package com.local.conoce_hervs.fragments.VistasDetalle;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.local.conoce_hervs.R;
import com.local.conoce_hervs.model.ModelPuntos;
import com.local.conoce_hervs.picasso.PicassoCache;

public class FragmentDetalleInteres extends android.app.Fragment {




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detalle_interes, container, false);
        Bundle bundle = getArguments();
        ModelPuntos puntosInteres;
        ConstraintLayout constraintLayout = new ConstraintLayout(getActivity());

        if (bundle != null) {
            puntosInteres = bundle.getParcelable("posicion");
            String nombre, mapa, descripcion, foto;
            nombre=puntosInteres.getNombre().toString();
            descripcion=puntosInteres.getDescripcion().toString();
            //mapa=puntosInteres.getMapa().toString();
            foto=puntosInteres.getFoto().toString();
            TextView nombreInteres = v.findViewById(R.id.nombre_interes);
            TextView infoInteres = v.findViewById(R.id.info_interes);
            //TextView mapaInteres = v.findViewById(R.id.mapa_interes);
            ImageView fotoInteres=v.findViewById(R.id.foto_interes);

            nombreInteres.setText(nombre);
            //mapaInteres.setText(mapa);
            infoInteres.setText(descripcion);
            PicassoCache.getPicassoInstance(this.getActivity()).load(foto)
                    .resize(450, 300)
                    .into(fotoInteres);
        }

        return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



}
