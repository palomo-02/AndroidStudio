package com.example.appfantasmahalloween;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Process;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;  // Make sure to import Toast
import android.view.View;   // Needed for OnClickListener

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mostrar el Toast
                Toast.makeText(MainActivity.this, "¡Has liberado al programador fantasma! 👻", Toast.LENGTH_SHORT).show();

                // Reproducir el sonido
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.boo);
                mp.start();

                // Liberar recursos cuando termine
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
    }
}