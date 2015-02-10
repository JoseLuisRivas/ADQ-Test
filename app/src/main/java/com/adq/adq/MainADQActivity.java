package com.adq.adq;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


public class MainADQActivity extends ActionBarActivity  {

    public static final String TAG = "MainActivity";
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onClick(View v){
     // creo un widget tipo toast para saber si el boton esta raccionando al evento clic
        Toast.makeText(this, "Estoy escuchando", Toast.LENGTH_LONG).show();

        // creo un obj tipo intent
        // le paso dos parametros que son las activity donde me encuentro y el activity donde quiero ir
        Intent intent = new Intent(this, HotelsActivity.class);
        // en el intent se puede cargar textos, banderas, package, obtener valores, etc
        // intent.setXXXX  o intent.getXXXXX

        // Hacemos el paso a la otra actividad

        startActivity(intent);


    }




}
