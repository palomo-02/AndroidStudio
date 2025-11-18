package com.example.aplicacionrepaso_palomo_zambrano_jose_manuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

            videoView.start();
            andando = true;
            cont++;

        });

        pasosTotal.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "cuantos paseo ha dado el pollo?: " + cont + " pasos en total", Toast.LENGTH_SHORT).show();
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.Puzzle:

                Intent intent1 = new Intent(this, vistaPuzzle.class);
                startActivity(intent1);

                break;

            default:


                return super.onOptionsItemSelected(item);
        }



        return true;
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