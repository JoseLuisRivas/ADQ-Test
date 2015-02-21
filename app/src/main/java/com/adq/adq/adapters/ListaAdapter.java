package com.adq.adq.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adq.adq.R;
import com.adq.adq.models.Hotel;
import com.adq.adq.models.Lista;

import java.util.ArrayList;


// 1. Extendemos o heredamos para que esta clase se comporte como una RecyclerView.Adapter
// y el adapter va a tener una clase interna que va a servir de Holder

    // ViewHolder nos almacena las vista findViewById, que es lo que mas consume recursos y con este solo lo hacemos una sola vez
    public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

        // 3.  Para trabajar con el dataset creo un ArrayList
        ArrayList<Lista> listas;
        int itemLayout; // Indice del row


        // 4.  Para acceder a las configuraciones que le vamos a enviar desde el fragmento, creamos un constructor
        public ListaAdapter(ArrayList<Lista> listas, int itemLayout) {
            // Guardo los valores
            this.listas = listas;
            this.itemLayout = itemLayout;
        }


        @Override
        public void onBindViewHolder(ListaAdapter.ViewHolder viewHolder, int i) {
// 8. Seteamos la información y la plasmamos sobre los widget
// instanciamos un Lista por cada elemento que venga de nuestro arreglo Lista
// Genero un primer objeto tipo cancion del primmer valor del dataset
            Lista hotel = listas.get(i);

// del ViewHolder voy a guardar los elementos
// hotelNombre le seteo un texto, que viene del mismo objeto y lo obtengo con getNombre
            viewHolder.hotelNombre.setText(hotel.getNombreHotel());
            viewHolder.municipio.setText(hotel.getMunicipio());
            viewHolder.start.setNumStars(hotel.getStart());
// 10. Nos vamos a HotelesFragment
        }

        @Override
        public ListaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
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
// 7. Necesito retornar el tamaño del dataSet, que en este caso es el ArrayList, que se llama listas
// le digo que retorne el tamaño del dataset que viene modelado como canciones
            return listas.size();
        }

// Ojo Borrar si no funciona

// Ojo Fin Borrar si no funciona

        // 2. Vreo la clase ViewHolder
        public class ViewHolder extends RecyclerView.ViewHolder{
            // 6. Hacemos el llamado de todos elementos que creamos a partir del modelo Lista y que se mostraran en la vista row_hoteles
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
