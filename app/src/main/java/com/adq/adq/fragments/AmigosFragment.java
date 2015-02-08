package com.adq.adq.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adq.adq.R;

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
