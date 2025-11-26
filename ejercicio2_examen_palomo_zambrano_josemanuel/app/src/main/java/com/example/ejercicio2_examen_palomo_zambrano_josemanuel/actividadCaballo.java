package com.example.ejercicio2_examen_palomo_zambrano_josemanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actividadCaballo extends AppCompatActivity {


    EditText valoracion;

    EditText comentario;
    Button guardar;
    Button volver;
    Button mostrarReseñacaballo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_caballo);

        comentario = findViewById(R.id.editTextComentario);
        guardar = findViewById(R.id.botonGuardar);
        volver = findViewById(R.id.botonReturn);
        mostrarReseñacaballo = findViewById(R.id.mostrarReseñaCaballo);
        valoracion = findViewById(R.id.editTextReseña);


        SharedPreferences spf = getSharedPreferences("Reseñacaballo", MODE_PRIVATE);
        String ultimoSitio = spf.getString("claveCaballo", "sin reseñas");


        SharedPreferences spfvaloracion = getSharedPreferences("valoracioncaballo", MODE_PRIVATE);
        String ultimareseña = spf.getString("reseñaCaballo", "sin valoraciones");


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


            }
        });


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String textoIngresado = comentario.getText().toString();

                if (!textoIngresado.isEmpty()) {

                    SharedPreferences.Editor editor = spf.edit();
                    editor.putString("claveCaballo", textoIngresado);
                    editor.apply();


                    SharedPreferences.Editor reseñas = spfvaloracion.edit();
                    editor.putString("reseñaCaballo", textoIngresado);
                    editor.apply();


                    Toast.makeText(actividadCaballo.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();

                }
            }
        });


        mostrarReseñacaballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(actividadCaballo.this, "ultimo comentario: " + ultimoSitio, Toast.LENGTH_LONG).show();

                Toast.makeText(actividadCaballo.this, "ultima reseña: " + ultimareseña, Toast.LENGTH_LONG).show();

            }
        });


    }
}