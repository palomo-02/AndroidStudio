package com.example.tarea4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {
    private boolean mostrarEuro = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNombre = findViewById(R.id.editTextNombre);
        Button buttonSaludar = findViewById(R.id.buttonSaludar);
        Button buttonContar = findViewById(R.id.buttonContar);
        TextView textViewResultado = findViewById(R.id.textViewResultado);
        Button button6 = findViewById(R.id.button6);
        Button botonFecha = findViewById(R.id.botonFecha);
        Button botonHora = findViewById(R.id.botonHora);

        buttonSaludar.setOnClickListener(v -> {
            String nombre = editTextNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                textViewResultado.setText("Por favor, escribe tu nombre");
            } else {
                String saludo = getString(R.string.greeting) + " " + nombre;
                textViewResultado.setText(saludo);
            }
        });

        buttonContar.setOnClickListener(v -> {
            String nombre = editTextNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                textViewResultado.setText("Por favor, escribe tu nombre");
            } else {
                String resultado = getString(R.string.count_letters) + " " +
                        nombre.length() + " " + getString(R.string.letters);
                textViewResultado.setText(resultado);
            }
        });

        botonFecha.setOnClickListener(v -> {
            Date fechaActual = new Date();
            DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
            String fechaFormateada = formatoFecha.format(fechaActual);
            textViewResultado.setText(fechaFormateada);
        });

        botonHora.setOnClickListener(v -> {
            Date fechaActual = new Date();
            DateFormat formatoHora = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
            String horaFormateada = formatoHora.format(fechaActual);
            textViewResultado.setText(horaFormateada);
        });

        button6.setOnClickListener(v -> {
            double numeroDecimal = 1234.56;
            double importe = 19.99;

            NumberFormat formatoDecimal = NumberFormat.getInstance(Locale.getDefault());
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());

            // Corrección: usar .format() como método, no como función
            textViewResultado.setText("Decimal: " + formatoDecimal.format(numeroDecimal) + "  |  Moneda: " + formatoMoneda.format(importe));
        });
    }
}
