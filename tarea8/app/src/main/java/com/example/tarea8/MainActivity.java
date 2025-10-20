package com.example.tarea8;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private Button btnGuardar, btnMostrar;
    private TextView tvResultado;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MiAppPrefs";
    private static final String KEY_NOMBRE = "nombreUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnMostrar = findViewById(R.id.btnMostrar);
        tvResultado = findViewById(R.id.tvResultado);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Guardar nombre al pulsar "Guardar"
        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            if (!nombre.isEmpty()) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NOMBRE, nombre);
                editor.apply();  // Guarda los cambios
                Toast.makeText(getApplicationContext(), "Dato guardado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Escribe un nombre primero", Toast.LENGTH_SHORT).show();
            }
        });

        // Mostrar nombre al pulsar "Mostrar"
        btnMostrar.setOnClickListener(v -> {
            String nombreGuardado = sharedPreferences.getString(KEY_NOMBRE, "No hay nombre guardado");
            tvResultado.setText(nombreGuardado);
            Toast.makeText(getApplicationContext(), "Nombre: " + nombreGuardado, Toast.LENGTH_SHORT).show();
        });
    }
}
