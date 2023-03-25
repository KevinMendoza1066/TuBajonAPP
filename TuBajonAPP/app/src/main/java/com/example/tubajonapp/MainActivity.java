package com.example.tubajonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables
    private static int INICIO = 5000;
    Animation topAnim,bottomAnim;
    ImageView fondo,logo;
    TextView Nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /*Implementamos Animaciones*/
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anima);

        //Llamamos id
        logo =findViewById(R.id.imageView7);
        fondo =findViewById(R.id.imageView6);
        Nombre =findViewById(R.id.textView2);

        Nombre.setAnimation(bottomAnim);
        fondo.setAnimation(topAnim);
        logo.setAnimation(topAnim);

        //Para esperar 5 segundos antes de pasar al login
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(logo,"imvLogoImagen");
                pairs[1] = new Pair<View,String>(Nombre,"tvBienvenida");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent,options.toBundle());
                finish();

            }
        },INICIO);
    }
}