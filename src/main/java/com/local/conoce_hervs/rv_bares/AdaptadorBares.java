package com.local.conoce_hervs.rv_bares;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.local.conoce_hervs.R;
import com.local.conoce_hervs.db_bares.Bar;

import java.util.List;

/**
 * Created by acer on 16/03/2018.
 */

public class AdaptadorBares extends RecyclerView.Adapter<AdaptadorBares.BaresViewHolder> {

    List<Bar> bares;

    /**
     * Constructor
     *
     * @param bares
     */
    public AdaptadorBares(List<Bar> bares) {
        this.bares = bares;
    }

    @Override
    public AdaptadorBares.BaresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_bares, parent, false);
        AdaptadorBares.BaresViewHolder bvh = new AdaptadorBares.BaresViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(BaresViewHolder holder, int position) {
        holder.barNombre.setText(bares.get(position).nombreBares.get(1));
        holder.barPhoto.setImageResource(Integer.parseInt(bares.get(position).fotosBares.get(5)));
    }


    @Override
    public int getItemCount() {

        return bares.size();
    }


    /**
     * SubClase para el ViewHolder
     */
    public static class BaresViewHolder extends RecyclerView.ViewHolder {
        CardView cvBar;
        TextView barNombre;
        ImageView barPhoto;

        BaresViewHolder(View itemView) {
            super(itemView);
            cvBar = itemView.findViewById(R.id.cvBar);
            barNombre = itemView.findViewById(R.id.barName);
            barPhoto = itemView.findViewById(R.id.barPhoto);
        }


    }

}