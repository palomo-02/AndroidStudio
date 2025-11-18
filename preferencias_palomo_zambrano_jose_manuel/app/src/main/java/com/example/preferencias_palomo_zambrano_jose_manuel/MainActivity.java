package com.example.preferencias_palomo_zambrano_jose_manuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPreferencias = findViewById(R.id.button);
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent explícito para abrir la pantalla de ajustes
                Intent intent = new Intent(MainActivity.this, opcionesPreferencias.class);
                startActivity(intent);
            }
        });







    }
}