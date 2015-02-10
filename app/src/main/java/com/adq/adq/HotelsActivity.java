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
import com.adq.adq.fragments.PerfilFragment;



//    public class HotelsActivity extends Activity implements ActionBar.TabListener {
//public class HotelsActivity extends ActionBarActivity implements View.OnClickListener {
public class HotelsActivity extends ActionBarActivity implements View.OnTouchListener {
/*
    private Fragment[] fragments = new Fragment[]{
        new HotelesFragment(),
        new AmigosFragment(),
        new PerfilFragment()
};
*/
private ImageButton btnVistaLista, btnFavoritos, btnVistaMap;
private HotelesFragment fragmentListar;
private AmigosFragment fragmentAmigos;
private PerfilFragment fragmentPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
/*
        Typeface iconsFamily = Typeface.createFromAsset(getAssets(), "fonts/glyphIcons.ttf");


        TextView iconUser = (TextView) findViewById(tv_list_fgm_hotels);
        iconUser.setTypeface(iconsFamily);
        iconUser.setText("\ue604");

        TextView iconHeart = (TextView) findViewById(R.id.tv_maps_fgm_hotels);
        iconHeart.setTypeface(iconsFamily);
        iconHeart.setText("\ue601");

        TextView iconComment = (TextView) findViewById(R.id.tv_photos_fgm_hotels);
        iconComment.setTypeface(iconsFamily);
        iconComment.setText("\ue610");
 */

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        btnVistaLista = (ImageButton) findViewById(R.id.btn_vista_lista);
        btnVistaLista.setOnTouchListener(this);
        btnFavoritos = (ImageButton) findViewById(R.id.btn_favoritos);
        btnFavoritos.setOnTouchListener(this);
        btnVistaMap = (ImageButton) findViewById(R.id.btn_vista_map);
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
        }
    }
// TODO :  sedebe crear los auditores para que funcione la nueva barra - Video 20 - Finalizando Fragment Dinamicos
/*       @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        for (Fragment fragment : fragments){
            fragmentTransaction.add(R.id.rl_activity_ppal_hoteles, fragment).hide(fragment);
        }
        switch(v.getId()) {
            case R.id.btn_vista_lista: // R.id.textView1

                Toast.makeText(this, "VIEW ALL", Toast.LENGTH_SHORT).show();

                tvList = (TextView) v.findViewById(R.id.tv_list_fgm_hotels);

                tvList.setTextColor(getResources().getColorStateList(R.color.color_secundary_adq));

                intent = new Intent(this, HotelsActivity.class);

                break;
            case R.id.btn_favoritos: // R.id.textView2

                fragmentTransaction.show(fragments[1]).commit();
               Toast.makeText(this, "VIEW ALL", Toast.LENGTH_SHORT).show();
                tvMaps = (TextView) v.findViewById(R.id.tv_list_fgm_hotels);
                try {
                    tvMaps.setTextColor(0xFFFFFFFF);
                } catch (Exception e) {}
                intent = new Intent(this, AmigosActivity.class);

                break;
            case R.id.btn_vista_map: // R.id.textView3
                intent = new Intent();
        }
        startActivity(intent);
    }
*/

}
