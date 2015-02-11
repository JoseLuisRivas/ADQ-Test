package com.adq.adq.adapters;

// Minuto 16:16 - Video 3 - Vollley Framework -->

// Pasos para trabajar con RecyclerView
// 1. Creo Modelo Hotel con sus getters y setters
// 2. Creo la vista fragment_hoteles, de tipo FrameLayout, que contiene una android.support.v7.widget.RecyclerView
// 3. Creo la vista row_hoteles,
// 4. Creo la clase HotelesAdapter


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adq.adq.R;
import com.adq.adq.models.Hotel;

import java.util.ArrayList;

// 1. Extendemos o heredamos para que esta clase se comporte como una RecyclerView.Adapter
// y el adapter va a tener una clase interna que va a servir de Holder

// ViewHolder nos almacena las vista findViewById, que es lo que mas consume recursos y con este solo lo hacemos una sola vez
public class HotelesAdapter extends RecyclerView.Adapter<HotelesAdapter.ViewHolder>{

// 3.  Para trabajar con el dataset creo un ArrayList
    ArrayList<Hotel> hoteles;
    int itemLayout; // Indice del row


// 4.  Para acceder a las configuraciones que le vamos a enviar desde el fragmento, creamos un constructor
    public HotelesAdapter(ArrayList<Hotel> hoteles, int itemLayout) {
        // Guardo los valores
        this.hoteles = hoteles;
        this.itemLayout = itemLayout;
    }


    @Override
    public void onBindViewHolder(HotelesAdapter.ViewHolder viewHolder, int i) {
// 8. Seteamos la información y la plasmamos sobre los widget
// instanciamos un Hotel por cada elemento que venga de nuestro arreglo Hotel
// Genero un primer objeto tipo cancion del primmer valor del dataset
        Hotel hotel = hoteles.get(i);

// del ViewHolder voy a guardar los elementos
// hotelNombre le seteo un texto, que viene del mismo objeto y lo obtengo con getNombre
        viewHolder.hotelNombre.setText(hotel.getNombreHotel());
        viewHolder.municipio.setText(hotel.getMunicipio());
        viewHolder.start.setNumStars(hotel.getStart());
// 10. Nos vamos a HotelesFragment
    }

    @Override
    public HotelesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// 5. Hago que el holder infle la vista cuyo indice me llega en el itemLayout
// de un nuevo obj tipo View y hacemos que la vista se pegue en el contexto del framento
// entonces con viewGroup le decimos que tome el contexto desde donde se mande a llamar este adapter
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);

// lo inflamos de itemLayout, que lo pegue a la misma vista y no voy a heredar o recibir ninguna vista de otro lado -> comando ->inflate(itemLayout, viewGroup, false)

// Se retorna un ViewHolder porque es quien nos permite hacer el findViewById, porque primero nececitamos inflar o generar la vista y para poder usar los widgeds de la vista
        return new ViewHolder(v);
// Nota_: LayoutInflater viene de otro contexto diferente al activity
    }

    @Override
    public int getItemCount() {
// 7. Necesito retornar el tamaño del dataSet, que en este caso es el ArrayList, que se llama hoteles
// le digo que retorne el tamaño del dataset que viene modelado como canciones
        return hoteles.size();
    }

// 2. Vreo la clase ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
// 6. Hacemos el llamado de todos elementos que creamos a partir del modelo Hotel y que se mostraran en la vista row_hoteles
    TextView hotelNombre;
    TextView municipio;
    RatingBar start;

    public ViewHolder(View itemView) {
        super(itemView);

        hotelNombre = (TextView) itemView.findViewById(R.id.hotel_nombre_item);
        municipio = (TextView) itemView.findViewById(R.id.hotel_municipio_item);
        start = (RatingBar) itemView.findViewById(R.id.hotel_ratingBar_item);

    }
}
}
