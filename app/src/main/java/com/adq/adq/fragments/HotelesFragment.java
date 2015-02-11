package com.adq.adq.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adq.adq.R;
import com.adq.adq.adapters.HotelesAdapter;
import com.adq.adq.models.Hotel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelesFragment extends Fragment {


    public HotelesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Retorna una vista que voy a inflar
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hoteles, container, false);

    }
// viene de HotelesAdapter paso 10
// 11. Sobre escribo el metodo onActivityCreated
   @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

// 13. Creo un dataset, que luego se va a reemplazar con datos remotos traidos con FrameWork http Volley

       ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
       Hotel hotel = new Hotel();
       hotel.setNombreHotel("Hotel del Campo");
       hotel.setMunicipio("Químbaya");
       hotel.setStart(3);
       hoteles.add(hotel);

       Hotel hotel1 = new Hotel();
       hotel1.setNombreHotel("Hotel del Campo 1");
       hotel1.setMunicipio("Químbaya 1");
       hotel1.setStart(1);
       hoteles.add(hotel1);

       Hotel hotel2 = new Hotel();
       hotel2.setNombreHotel("Hotel del Campo 2");
       hotel2.setMunicipio("Químbaya 2");
       hotel2.setStart(4);
       hoteles.add(hotel2);

       Hotel hotel3 = new Hotel();
       hotel3.setNombreHotel("Hotel del Campo 3");
       hotel3.setMunicipio("Químbaya 1");
       hotel3.setStart(2);
       hoteles.add(hotel3);

       Hotel hotel4 = new Hotel();
       hotel4.setNombreHotel("Hotel del Campo 4");
       hotel4.setMunicipio("Químbaya 1");
       hotel4.setStart(4);
       hoteles.add(hotel4);

       Hotel hotel5 = new Hotel();
       hotel5.setNombreHotel("Hotel del Campo 5");
       hotel5.setMunicipio("Químbaya 1");
       hotel5.setStart(5);
       hoteles.add(hotel5);

// 12. Llamo al RecyclerView -  minuto 28:33 - video 3 Volley
       RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view_hoteles);
       recyclerView.setHasFixedSize(true);
       recyclerView.setAdapter(new HotelesAdapter(hoteles, R.layout.row_hoteles));
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
