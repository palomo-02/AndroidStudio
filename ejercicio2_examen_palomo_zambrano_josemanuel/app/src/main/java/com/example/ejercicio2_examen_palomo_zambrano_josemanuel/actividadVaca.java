package com.example.ejercicio2_examen_palomo_zambrano_josemanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actividadVaca extends AppCompatActivity {

    EditText comentario;
    Button guardar;
    Button volver;
    Button mostrarVaca;

    EditText valoracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_vaca);

        comentario = findViewById(R.id.editTextComentario);
        guardar = findViewById(R.id.botonGuardar);
        volver = findViewById(R.id.botonReturn);
        mostrarVaca = findViewById(R.id.mostrarReseñavaca);
        valoracion = findViewById(R.id.editTextReseña);


        SharedPreferences spf = getSharedPreferences("ReseñaVaca", MODE_PRIVATE);
        String ultimoSitio = spf.getString("clavevaca", "sin reseñas");


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
                    editor.putString("clavevaca", textoIngresado);
                    editor.apply();

                    Toast.makeText(actividadVaca.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();


                }


            }
        });


        mostrarVaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(actividadVaca.this, "ultimo comentario: " + ultimoSitio, Toast.LENGTH_LONG).show();


            }
        });


    }
}