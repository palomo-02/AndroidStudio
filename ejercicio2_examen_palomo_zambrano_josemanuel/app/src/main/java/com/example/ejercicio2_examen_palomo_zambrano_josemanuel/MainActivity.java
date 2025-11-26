package com.example.ejercicio2_examen_palomo_zambrano_josemanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton botonVaca;
    ImageButton botonCaballo;
    ImageButton botonGallo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonCaballo = findViewById(R.id.btnImagenCaballo);
        botonGallo = findViewById(R.id.btnImagenGallo);
        botonVaca = findViewById(R.id.btnImagenVaca);


        botonVaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, actividadVaca.class);


                startActivity(intent);


            }
        });
        botonGallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, actividadGallo.class);


                startActivity(intent);


            }
        });
        botonCaballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, actividadCaballo.class);


                startActivity(intent);


            }
        });

    }
}