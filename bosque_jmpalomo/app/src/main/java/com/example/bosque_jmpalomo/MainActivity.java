package com.example.bosque_jmpalomo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private Button botonBosque, botonSalir;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setupClickListeners();
    }

    private void initViews() {
        imageButton = findViewById(R.id.imageButton);
        botonBosque = findViewById(R.id.botonBosuqe);
        botonSalir = findViewById(R.id.button2);

        mediaPlayer = MediaPlayer.create(this, R.raw.sonidobosque);
    }

    private void setupClickListeners() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        botonBosque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirSonidoBosque();
            }
        });

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salirAplicacion();
            }
        });
    }

    private void reproducirSonidoBosque() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.sonidobosque);
        mediaPlayer.start();
    }

    private void salirAplicacion() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        finishAffinity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}