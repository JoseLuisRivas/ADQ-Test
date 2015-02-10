package com.adq.adq.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adq.adq.R;
import com.adq.adq.models.Amigo;

import java.util.ArrayList;

// Minuto 1:28:48 video 2 - Recycler, Card View
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.ViewHolder> {

    private ArrayList<Amigo> amigos;
    private int itemLayout;   // Item de la lista

    public AmigosAdapter(ArrayList<Amigo> amigos, int itemLayout) {
        this.amigos = amigos; // el amigo de esta calse va a ser igual al que yo reciba
        this.itemLayout = itemLayout;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Amigo amigo = amigos.get(i);

        viewHolder.amigoNombre.setText(amigo.getNombreAmigo());
        viewHolder.amigoTwitter.setText(amigo.getTwitter());
//        viewHolder.amigoUltimo.setText(amigo.getUltimoHotel());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }



    @Override
    public int getItemCount() {
        // Minuto 1:31:48 video 2
        return amigos.size();
    }

    //public AmigosAdapter(ArrayList<Amigo> amigos, int layout  ){}

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // elemetos de la lsita row_amigos
        public TextView amigoNombre;
        public TextView amigoTwitter;
        public TextView amigoUltimo;

        public ViewHolder(View itemView) {
            super(itemView);

            amigoNombre = (TextView) itemView.findViewById(R.id.amigo_nombre);
            amigoTwitter = (TextView) itemView.findViewById(R.id.amigo_twitter);
            amigoTwitter = (TextView) itemView.findViewById(R.id.amigo_ultimo_hotel);

        }
    }
}
