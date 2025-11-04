package com.example.aplicacionrepaso_palomo_zambrano_jose_manuel;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private VideoView videoView;

    private boolean andando = false;
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        EditText cambiarPollo = findViewById(R.id.escribaAquiTextoPollo);
        Button botonCambiarNombre = findViewById(R.id.botonCambiarNombre);
        Button botonAndar = findViewById(R.id.botonAndar);
        TextView textViewResultado = findViewById(R.id.imagenpollo);
        Button pasosTotal = findViewById(R.id.pasosEnTotal);

        try {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.pollitoandador;
            videoView.setVideoURI(Uri.parse(path));

            // Cuando el video termine, volver al inicio
            videoView.setOnCompletionListener(mp -> {
                videoView.seekTo(0);
                andando = false;
            });
        } catch (Exception e) {
            textViewResultado.setText("Error cargando video");
            e.printStackTrace();
        }

        botonCambiarNombre.setOnClickListener(v -> {
            String nombre = cambiarPollo.getText().toString().trim();
            if (nombre.isEmpty()) {
                textViewResultado.setText("Por favor, dale un nombre al pollo");
            } else {
                String saludo = "El nuevo nombre del pollo es: " + nombre;
                textViewResultado.setText(saludo);
            }
        });

        botonAndar.setOnClickListener(v -> {
            if (!andando) {
                // Iniciar video
                videoView.start();
                andando = true;
                botonAndar.setText("Parar pollo");
                cont++;
            } else {
                // Parar video
                videoView.pause();
                videoView.seekTo(0); // Volver al inicio
                andando = false;
                botonAndar.setText("Hacer que el pollo ande");
            }
        });

        pasosTotal.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "El pollo ha dado: " + cont+7 + " pasos en total", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (videoView != null && andando) {
            videoView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (andando && videoView != null) {
            videoView.start();
        }
    }
}