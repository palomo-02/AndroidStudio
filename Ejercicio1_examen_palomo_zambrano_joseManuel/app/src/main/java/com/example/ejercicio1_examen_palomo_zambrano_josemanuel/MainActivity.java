package com.example.ejercicio1_examen_palomo_zambrano_josemanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    Button reproductor;
    Button CalculoFinal;
    EditText precioBase;
    EditText descuento;
    TextView precioFinal;
    Button guardarComentario;
    EditText comentario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        reproductor = findViewById(R.id.BotonActividad);
        CalculoFinal = findViewById(R.id.botoncalcularPrecio);
        precioBase = findViewById(R.id.precioBase);
        descuento = findViewById(R.id.descuento);
        precioFinal = findViewById(R.id.precioFinal);
        comentario = findViewById(R.id.comentario);
        guardarComentario = findViewById(R.id.guardarComentario);





        SharedPreferences spf = getSharedPreferences("MisDatos", MODE_PRIVATE);
        String ultimoSitio = spf.getString("clave", "sin comentarios");
        Toast.makeText(this, "ultimo comentario: " + ultimoSitio, Toast.LENGTH_LONG).show();


        reproductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Reproductor.class);

                startActivity(intent);

            }
        });


        guardarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoIngresado = comentario.getText().toString();
                if (!textoIngresado.isEmpty()) {
                    SharedPreferences.Editor editor = spf.edit();
                    editor.putString("clave", textoIngresado);
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Comentario Guardado", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, "Escribe un comentario anda", Toast.LENGTH_SHORT).show();
                }

            }
        });


        CalculoFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String preciobaseAstring = precioBase.getText().toString();
                String descuentoAstring = descuento.getText().toString();


                if (!preciobaseAstring.isEmpty()) {


                    double precioParaCalcular = Double.parseDouble(preciobaseAstring);

                    double descuentoParaCalcular = Double.parseDouble(descuentoAstring);

                    if (precioParaCalcular < 0 || (descuentoParaCalcular < 0 || descuentoParaCalcular > 100)) {


                        Toast.makeText(MainActivity.this, "El precio base ha de ser mayor que 0 y el descuento entre o y 100", Toast.LENGTH_SHORT).show();


                    } else {

                        double resultado = (precioParaCalcular * descuentoParaCalcular) / 100;

                        double enseñar = precioParaCalcular - resultado;


                        String dinero = NumberFormat.getCurrencyInstance().format(enseñar);

                        precioFinal.setText(dinero);
                    }


                } else {

                    Toast.makeText(MainActivity.this, "Asegurate que todos los campos estan rellenos", Toast.LENGTH_SHORT).show();


                }


            }
        });


    }
}