package com.local.conoce_hervs.rv_puntosinteres;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.local.conoce_hervs.R;

import java.util.List;

public class AdaptadorInteres extends RecyclerView.Adapter<AdaptadorInteres.InteresViewHolder> {

        Context context;
        List<Puntos> puntos;
        int layout;


        public AdaptadorInteres(List<Puntos> puntos) {
            this.puntos = puntos;
        }

        @Override
        public AdaptadorInteres.InteresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_interes, parent, false);
            AdaptadorInteres.InteresViewHolder ivh = new AdaptadorInteres.InteresViewHolder(v);

            return ivh;

        }

        @Override
        public void onBindViewHolder(AdaptadorInteres.InteresViewHolder holder, int position) {

            Puntos punto = puntos.get(position);

           //holder.puntoNombre.setText(punto.get(position).);
            //holder.puntoPhoto.setImageResource(punto.getFotoPuntoId());

            holder.puntoNombre.setText(puntos.get(position).nomPunto);
            holder.puntoPhoto.setImageResource(puntos.get(position).fotoPuntoId);


        }

        @Override
        public int getItemCount() {
            return puntos.size();
        }

        /*
        * Subclase para el viewHolder
        * */

        public static class InteresViewHolder extends RecyclerView.ViewHolder {
            public CardView cvint;
            public TextView puntoNombre;
            public ImageView puntoPhoto;



            InteresViewHolder(View itemView) {
                super(itemView);
                cvint = itemView.findViewById(R.id.cvinteres);
                puntoNombre = itemView.findViewById(R.id.interesnombre);
                puntoPhoto = itemView.findViewById(R.id.interesfoto);
            }


        }


    }


