package com.example.tubajonapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.tubajonapp.Fragment.Favoritos;
import com.example.tubajonapp.Fragment.Inicio;
import com.example.tubajonapp.Fragment.Mapa;
import com.example.tubajonapp.Fragment.Perfil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dash extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNavigationView = findViewById(R.id.bottonnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new Inicio());
    }
    public boolean onNavigationItemSelected( MenuItem item) {//Aca registramos que item seleccionamos
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.mit_inicio:
                fragment = new Inicio();
                break;
            case R.id.mit_mapa:
                fragment = new Mapa();
                break;
            case R.id.mit_favoritos:
                fragment = new Favoritos();
                break;
            case R.id.mit_perfil:
                fragment = new Perfil();
                break;
            case R.id.mit_salir:

                break;
        }
        if (fragment != null) {
            loadFragment(fragment);

        }
        return true;
    }
    void loadFragment(Fragment fragment) {
        //to attach fragment
        //Sustituimos el relative layout por el fragmento correcto
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                .replace(R.id.relativelayout, fragment)
                .commit();

    }
}