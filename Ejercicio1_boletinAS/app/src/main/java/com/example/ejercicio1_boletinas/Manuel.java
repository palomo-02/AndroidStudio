package com.example.ejercicio1_boletinas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

public class Manuel extends AppCompatActivity {

    TextView tvSaludo;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistente); // Asegúrate de que tu XML se llame así

        tvSaludo = findViewById(R.id.tvSaludo);
        btnVolver = findViewById(R.id.btnVolver);

        // 1. Recuperar el nombre de SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        String nombre = prefs.getString("nombreUsuario", "Usuario");

        // 2. Determinar el saludo según la hora
        String saludo = obtenerSaludoSegunHora();

        // 3. Mostrar el texto final
        tvSaludo.setText(saludo + ", " + nombre + "!");

        // 4. Botón Volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta actividad y vuelve a la anterior
            }
        });
    }

    private String obtenerSaludoSegunHora() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY); // Formato 24h (0-23)

        if (hora >= 6 && hora < 12) {
            return "¡Buenos días";
        } else if (hora >= 12 && hora < 20) {
            return "¡Buenas tardes";
        } else {
            return "¡Buenas noches";
        }
    }
}