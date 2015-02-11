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
import com.adq.adq.adapters.AmigosAdapter;
import com.adq.adq.models.Amigo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmigosFragment extends Fragment {


    public AmigosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amigos, container, false);
    }

    // Minuto 1:37:15 - Video 2
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Amigo> amigoArrayList = new ArrayList<Amigo>();

        Amigo joseluis =  new Amigo();
        joseluis.setNombreAmigo("Jose Luis");
        joseluis.setTwitter("JoseLuis3");
        joseluis.setUltimoHotel("Hotel del Campo");
        amigoArrayList.add(joseluis);

        Amigo joseluis1 =  new Amigo();
        joseluis1.setNombreAmigo("Jose Luis");
        joseluis1.setTwitter("JoseLuis3");
        joseluis1.setUltimoHotel("Hotel del Campo");
        amigoArrayList.add(joseluis1);

        Amigo joseluis2 =  new Amigo();
        joseluis2.setNombreAmigo("Jose Luis 2");
        joseluis2.setTwitter("JoseLuis3");
        joseluis2.setUltimoHotel("Hotel del Campo");
        amigoArrayList.add(joseluis2);

        Amigo joseluis3 =  new Amigo();
        joseluis3.setNombreAmigo("Jose Luis 3");
        joseluis3.setTwitter("JoseLuis3");
        joseluis3.setUltimoHotel("Hotel del Campo");

        amigoArrayList.add(joseluis3);

        Amigo joseluis4 =  new Amigo();
        joseluis4.setNombreAmigo("Jose Luis4");
        joseluis4.setTwitter("JoseLuis3");
        joseluis4.setUltimoHotel("Hotel del Campo");

        amigoArrayList.add(joseluis4);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view_amigos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AmigosAdapter(amigoArrayList, R.layout.row_amigos));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResumen of AmigosFragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("DEBUG", "onPause of AmigosFragment");
        super.onPause();
    }

}
