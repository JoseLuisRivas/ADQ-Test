package com.adq.adq;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.adq.adq.fragments.AmigosFragment;
import com.adq.adq.fragments.HotelesFragment;
import com.adq.adq.fragments.ListaJsonFragment;
import com.adq.adq.fragments.PerfilFragment;

/**
 * Created by root on 10/02/15.
 */
//public class UtilsActivity {
public class UtilsActivity extends ActionBarActivity implements View.OnTouchListener {

    private ImageButton btnVistaLista, btnFavoritos, btnVistaMap;
    private HotelesFragment fragmentListar;
    private AmigosFragment fragmentAmigos;
    private PerfilFragment fragmentPerfil;
    private ListaJsonFragment fragmentLista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        btnVistaLista = (ImageButton) findViewById(R.id.btn_vista_lista);
        btnVistaLista.setOnTouchListener(this);
        btnFavoritos = (ImageButton) findViewById(R.id.btn_favoritos);
        btnFavoritos.setOnTouchListener(this);
        btnVistaMap = (ImageButton) findViewById(R.id.btn_vista_map);
        btnVistaMap.setOnTouchListener(this);
        btnVistaMap = (ImageButton) findViewById(R.id.btn_lista_json);
        btnVistaMap.setOnTouchListener(this);

        cargarFragmento(getFragmentListar());
    }



    //<editor-fold desc="DescriptionMETODOS GET DE INICIALIZACION BAJO DEMANDA - LAZY INITIALIZATION">
    public HotelesFragment getFragmentListar() {
        if(fragmentListar == null){
            fragmentListar = new HotelesFragment();
        }
        return fragmentListar;
    }

    public AmigosFragment getFragmentAmigos() {
        if(fragmentAmigos == null){
            fragmentAmigos = new AmigosFragment();
        }
        return fragmentAmigos;
    }

    public PerfilFragment getFragmentPerfil() {
        if(fragmentPerfil ==  null ){
            fragmentPerfil = new PerfilFragment();
        }
        return fragmentPerfil;
    }

    public ListaJsonFragment getFragmentLista() {
        if(fragmentLista == null){
            fragmentLista = new ListaJsonFragment();
        }
        return fragmentLista;
    }

    //</editor-fold>

    // minuto 10:05 video 17 - FragmentManager
    private void cargarFragmento(Fragment fragmento) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.rl_activity_ppal_hoteles, fragmento);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        ImageButton btn = (ImageButton) view;

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(this, String.valueOf(btn.getBackground()), Toast.LENGTH_SHORT).show();
        }

        int actionMasked = event.getActionMasked();
//        Toast.makeText(this, String.valueOf(actionMasked), Toast.LENGTH_SHORT).show();
        switch (actionMasked){
            case MotionEvent.ACTION_DOWN:
//                Toast.makeText(this, String.valueOf(actionMasked), Toast.LENGTH_SHORT).show();
                btn.setColorFilter(R.color.color_entintado_oscuro);
                btn.invalidate();
                cambiarFragmento(btn);
                break;
            case MotionEvent.ACTION_UP:
                btn.clearColorFilter();
                btn.invalidate();
                break;
        }
        return false;
    }

    private void cambiarFragmento(View btn) {
        switch (btn.getId()){
            case R.id.btn_vista_lista:
                Toast.makeText(this, "R.id.btn_vista_lista", Toast.LENGTH_SHORT).show();
                cargarFragmento(getFragmentListar());
                break;
            case R.id.btn_favoritos:
                Toast.makeText(this, "R.id.btn_favoritos", Toast.LENGTH_SHORT).show();
                cargarFragmento(getFragmentAmigos());
                break;
            case R.id.btn_vista_map:
                Toast.makeText(this, "R.id.btn_vista_map", Toast.LENGTH_SHORT).show();
                cargarFragmento(getFragmentPerfil());
                break;
            case R.id.btn_lista_json:
                Toast.makeText(this, "R.id.btn_lista_json", Toast.LENGTH_SHORT).show();
                cargarFragmento(getFragmentLista());
                break;
        }
    }

}
