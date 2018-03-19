package com.local.conoce_hervs.rv_hoteles;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.local.conoce_hervs.R;
import com.local.conoce_hervs.db_alojamientos.ModelAlojamiento;

import java.util.List;

public class AdaptadorHotel extends RecyclerView.Adapter<AdaptadorHotel.HotelesViewHolder> {

    List<ModelAlojamiento> hotels;

    /**
     * Constructor
     *
     * @param hotels
     */
    public AdaptadorHotel(List<ModelAlojamiento> hotels) {
        this.hotels = hotels;
    }

    @Override
    public HotelesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_hoteles, parent, false);
        HotelesViewHolder hvh = new HotelesViewHolder(v);

        return hvh;
    }

    @Override
    public void onBindViewHolder(HotelesViewHolder holder, int position) {
        holder.hotelNombre.setText(hotels.get(position).getNombre());

        Uri imgUri=Uri.parse(hotels.get(position).getFoto());

        holder.hotelPhoto.setImageURI(imgUri);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }


    /**
     * SubClase para el ViewHolder
     */
    public static class HotelesViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView hotelNombre;
        ImageView hotelPhoto;

        HotelesViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            hotelNombre = itemView.findViewById(R.id.hotelName);
            hotelPhoto = itemView.findViewById(R.id.hotelPhoto);
        }



    }

}
