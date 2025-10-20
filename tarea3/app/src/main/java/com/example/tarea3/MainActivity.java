package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button buttonPulsa = findViewById(R.id.buttonPulsa);
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        buttonPulsa.setOnClickListener(v -> {
            textViewResultado.setText("¡Estoy aprendiendo Android!");
        });












    }
}