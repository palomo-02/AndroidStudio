package com.example.ejercicio2_examen_palomo_zambrano_josemanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actividadGallo extends AppCompatActivity {

    EditText comentario;
    Button guardar;
    Button volver;
    Button mostrarGallo;
    EditText valoracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_gallo);


        comentario = findViewById(R.id.editTextComentario);
        guardar = findViewById(R.id.botonGuardar);
        volver = findViewById(R.id.botonReturn);
        mostrarGallo = findViewById(R.id.mostrarReseñaGallo);
        valoracion = findViewById(R.id.editTextReseña);


        SharedPreferences spf = getSharedPreferences("ReseñaGallo", MODE_PRIVATE);
        String ultimoSitio = spf.getString("clavegallo", "sin reseñas");


        SharedPreferences spfvaloracion = getSharedPreferences("valoraciongallo", MODE_PRIVATE);
        String ultimareseña = spf.getString("reseñaGallo", "sin valoraciones");

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
                    editor.putString("clavegallo", textoIngresado);
                    editor.apply();


                    SharedPreferences.Editor reseñas = spfvaloracion.edit();
                    editor.putString("reseñaGallo", textoIngresado);
                    editor.apply();


                    Toast.makeText(actividadGallo.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();


                }


            }
        });


        mostrarGallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(actividadGallo.this, "ultimo comentario: " + ultimoSitio, Toast.LENGTH_LONG).show();

                Toast.makeText(actividadGallo.this, "ultima reseña: " + ultimareseña, Toast.LENGTH_LONG).show();

            }
        });


    }
}