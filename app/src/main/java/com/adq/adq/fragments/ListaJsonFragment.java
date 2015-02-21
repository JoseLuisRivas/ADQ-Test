package com.adq.adq.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adq.adq.R;
import com.adq.adq.adapters.HotelesAdapter;
import com.adq.adq.adapters.ListaAdapter;
import com.adq.adq.models.Lista;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaJsonFragment extends Fragment {


    public ListaJsonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_json, container, false);
    }

    // viene de HotelesAdapter paso 10
// 11. Sobre escribo el metodo onActivityCreated
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

// 13. Creo un dataset, que luego se va a reemplazar con datos remotos traidos con FrameWork http Volley

//       ArrayList<Lista> hoteles = new ArrayList<Lista>();
// Androi studio suguiere usar <> en vez de <Lista
        ArrayList<Lista> hoteles = new ArrayList<>();
        Lista hotel = new Lista();
        hotel.setNombreHotel("Lista del Campo");
        hotel.setMunicipio("Químbaya");
        hotel.setStart(3);
        hoteles.add(hotel);

        Lista hotel1 = new Lista();
        hotel1.setNombreHotel("Lista del Campo 1");
        hotel1.setMunicipio("Químbaya 1");
        hotel1.setStart(1);
        hoteles.add(hotel1);

        Lista hotel2 = new Lista();
        hotel2.setNombreHotel("Lista del Campo 2");
        hotel2.setMunicipio("Químbaya 2");
        hotel2.setStart(4);
        hoteles.add(hotel2);

        Lista hotel3 = new Lista();
        hotel3.setNombreHotel("Lista del Campo 3");
        hotel3.setMunicipio("Químbaya 1");
        hotel3.setStart(2);
        hoteles.add(hotel3);

        Lista hotel4 = new Lista();
        hotel4.setNombreHotel("Lista prueba nombre largo 4");
        hotel4.setMunicipio("Químbaya 1");
        hotel4.setStart(4);
        hoteles.add(hotel4);

        Lista hotel5 = new Lista();
        hotel5.setNombreHotel("Lista La Cristalina 5");
        hotel5.setMunicipio("Químbaya 1");
        hotel5.setStart(5);
        hoteles.add(hotel5);

        Lista hotel6 = new Lista();
        hotel6.setNombreHotel("Lista del Campo 1");
        hotel6.setMunicipio("Químbaya 1");
        hotel6.setStart(1);
        hoteles.add(hotel6);

        Lista hotel7 = new Lista();
        hotel7.setNombreHotel("Lista del Campo 2");
        hotel7.setMunicipio("Químbaya 2");
        hotel7.setStart(4);
        hoteles.add(hotel7);

        Lista hotel8 = new Lista();
        hotel8.setNombreHotel("Lista del Campo 3");
        hotel8.setMunicipio("Químbaya 1");
        hotel8.setStart(2);
        hoteles.add(hotel8);

        Lista hotel9 = new Lista();
        hotel9.setNombreHotel("Lista prueba nombre muy re largo largo 4");
        hotel9.setMunicipio("Químbaya 1");
        hotel9.setStart(4);
        hoteles.add(hotel9);

        Lista hotel10 = new Lista();
        hotel10.setNombreHotel("Lista La Cristalina 5");
        hotel10.setMunicipio("Químbaya 1");
        hotel10.setStart(5);
        hoteles.add(hotel10);

// 12. Llamo al RecyclerView -  minuto 28:33 - video 3 Volley.
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view_lista_json);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ListaAdapter(hoteles, R.layout.row_lista_json));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of HotelesFragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("DEBUG", "onPause of HotelesFragment");
        super.onPause();
    }

}
