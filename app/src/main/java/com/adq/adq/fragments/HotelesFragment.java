package com.adq.adq.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adq.adq.R;

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
