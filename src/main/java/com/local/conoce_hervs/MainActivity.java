package com.local.conoce_hervs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.local.conoce_hervs.db_alojamientos.DBAlojamientos;
import com.local.conoce_hervs.db_alojamientos.UtilidadesDB;
import com.local.conoce_hervs.db_bares.DatabaseBares;
import com.local.conoce_hervs.fragments.Alojamiento;
import com.local.conoce_hervs.fragments.ComoLlegar;
import com.local.conoce_hervs.fragments.Home;
import com.local.conoce_hervs.fragments.Informacion;
import com.local.conoce_hervs.fragments.PuntosInteres;
import com.local.conoce_hervs.fragments.Restauracion;
import com.local.conoce_hervs.fragments.Rutas;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Creamos la variable fuera del método onCreate para luego poder cerrarla.
    DrawerLayout drawer;
    UtilidadesDB utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        utils = new UtilidadesDB(this);


        //Toolbar = barra de menú
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Abre el menu
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //Seleccionamos cada opcion del menu a traves de un switch utilizando el metodo pushFrangment
    //y los constructores creados en cada clase
    protected void selectFragment(MenuItem item){

        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.nav_home:
                pushFragment(new Home());
                break;
            case R.id.nav_info:
                pushFragment(new Informacion());
                break;
            case R.id.nav_puntosinteres:
                pushFragment(new PuntosInteres());
                break;
            case R.id.nav_alojamiento:
                pushFragment(new Alojamiento());
                break;
            case R.id.nav_Restauracion:
                pushFragment(new Restauracion());
                break;
            case R.id.nav_Rutas:
                pushFragment(new Rutas());
                break;
            case R.id.nav_comollegar:
                pushFragment(new ComoLlegar());
                break;

        }

    }

    //metodo que utilizamos en switch
    protected void pushFragment(Fragment fragment){

        if(fragment == null)
            return;

        android.app.FragmentManager fragmentManager = getFragmentManager();

        if(fragmentManager != null){
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(fragmentTransaction != null){
                //vacio hace referencia al id de la pantalla de bienvenida
                fragmentTransaction.replace(R.id.vacio, fragment);
                fragmentTransaction.commit();
            }
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        selectFragment(item);
        Log.d("TAG", "Valor item: " + item.toString());

        // Cierra el menú (Toggle)
        drawer.closeDrawers();

        return false;

    }
}
