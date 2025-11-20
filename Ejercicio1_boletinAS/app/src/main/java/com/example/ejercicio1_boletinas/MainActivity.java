package com.example.ejercicio1_boletinas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button miBotonJava;
    EditText etNombre; // Variable renombrada para mayor claridad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar con el XML
        miBotonJava = findViewById(R.id.btnGuardar);
        etNombre = findViewById(R.id.etNombre);

        miBotonJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etNombre.getText().toString();

                if (!nombre.isEmpty()) {
                    // 1. Guardar en SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nombreUsuario", nombre);
                    editor.apply(); // Guarda cambios

                    // 2. Ir a la actividad "Manuel"
                    Intent intent = new Intent(MainActivity.this, Manuel.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, escribe un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}