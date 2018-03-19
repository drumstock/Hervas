package com.local.conoce_hervs.rv_rutas;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.local.conoce_hervs.R;

import java.util.List;

/**
 * Created by acer on 16/03/2018.
 */

public class AdaptadorRutas extends RecyclerView.Adapter<AdaptadorRutas.RutsViewHolder> {

    List<RutasRV> rutas;

    /**
     * Constructor
     *
     * @param rutas
     */


    public AdaptadorRutas(List<RutasRV> rutas) {
        this.rutas = rutas;
    }

    @Override
    public AdaptadorRutas.RutsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_rutas, parent, false);
        RutsViewHolder hvh = new RutsViewHolder(v);
        return hvh;
    }

    @Override
    public void onBindViewHolder(AdaptadorRutas.RutsViewHolder holder, int position) {
        holder.rutaNombre.setText(rutas.get(position).nomRuta);
        holder.rutaPhoto.setImageResource(rutas.get(position).photoIdRuta);
    }

    @Override
    public int getItemCount() {
        return rutas.size();
    }


    /**
     * SubClase para el ViewHolder
     */
    public static class RutsViewHolder extends RecyclerView.ViewHolder {
        CardView cvRuta;
        TextView rutaNombre;
        ImageView rutaPhoto;

        RutsViewHolder(View itemView) {
            super(itemView);
            cvRuta = itemView.findViewById(R.id.cv);
            rutaNombre = itemView.findViewById(R.id.rutaName);
            rutaPhoto = itemView.findViewById(R.id.rutaPhoto);
        }


    }
}