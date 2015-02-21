package com.adq.adq.fragments;


import android.app.ProgressDialog;
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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaJsonFragment extends Fragment {

    // Log tag
    private static final String TAG = ListaJsonFragment.class.getSimpleName();
    private ProgressDialog progressDialog;
            ArrayList<Lista> dataset;

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

// Minuto 43:27 video volley
// Paso la url de nuestro backend
        //String URL = "http://api.androidhive.info/songs/albums.php";
        String URL = "http://api.androidhive.info/json/movies.json";

            // Configuramos volley
            // le definicos que en algun momento vamos a haceer un request
            // Los fragmentos no tienen contexto
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Espere por favor", "Estamos preparando los datos");
//        progressDialog = new ProgressDialog(this);
//        // Showing progress dialog before making http request
//        progressDialog.setMessage("Cargando...");
//        progressDialog.show();
            // Esperamos un JsonRequest
            // Decalramos un JsonArrayRequest y le pasamos la URL, un listener cunado fue ok y un listener cundo fue erro
        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("respuesta", response.toString());

                dataset = new ArrayList<Lista>();
                dataset = parser(response);
                // hasta aqui ok
                //parser(response);
                progressDialog.cancel();
                //hidePDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.toString());

                VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hidePDialog();
                progressDialog.cancel();

            }
        });

        // hacemos la peticion y le pasamos el nombre de la peticcion que vamos a hacer
        queue.add(request);


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
        //recyclerView.setAdapter(new ListaAdapter(hoteles, R.layout.row_lista_json));
        recyclerView.setAdapter(new ListaAdapter(dataset, R.layout.row_lista_json));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Minuto 58:27 - video 3  volley - Llenar un ArrayList con la informacion traida con volley

    }

    private void hidePDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    // Minuto 58:40 - Video 3 - Volley - Convertir a arralis los datos de volley
    // Creo un metodo devolvera un dato de tipo ArrayList, que recibe la respuesta de volley
    public ArrayList<Lista> parser (JSONArray response){

        // ArrayList que es el que vamos a retornar
        ArrayList<Lista> hotelAuxiliar = new ArrayList<Lista>();

        for (int i = 0; i< response.length(); i++){
            // Creo objeto hotel, para guardar los elemettos de manera dinamica
            Lista hotel = new Lista();
            // Creo un JsonObjedt
            try {
                JSONObject jsonObject = (JSONObject) response.get(i);
                hotel.setNombreHotel(jsonObject.getString("title"));
                hotel.setMunicipio(jsonObject.getString("releaseYear"));
                hotel.setStart(jsonObject.getInt("rating"));

                Log.e("dato", hotel.toString());

                hotelAuxiliar.add(hotel);

                // Voy al metodo onResponse y hago el llamado a esta funcion con parser()

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
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
