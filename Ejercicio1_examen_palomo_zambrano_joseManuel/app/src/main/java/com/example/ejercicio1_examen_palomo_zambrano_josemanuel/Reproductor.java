package com.example.ejercicio1_examen_palomo_zambrano_josemanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Reproductor extends AppCompatActivity {

    VideoView video;
    Button botonPiar;
    Button botonVolver;
    Button botonParar;
    Button pararVideo;

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);


        video = findViewById(R.id.videoView);
        botonPiar = findViewById(R.id.botonPiar);
        botonParar = findViewById(R.id.botonParar);
        botonVolver = findViewById(R.id.botonVolver);

        pararVideo = findViewById(R.id.botonPararVideo);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.gallina;
        video.setVideoURI(Uri.parse(path));
        video.start();


        mediaPlayer = MediaPlayer.create(this, R.raw.sonidopollo);

        botonPiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {

                    mediaPlayer.start();

                }

            }
        });

        botonParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {

                    mediaPlayer.pause();

                }


            }
        });

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });
        pararVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (video.isPlaying()) {

                    video.pause();

                }


            }
        });


    }
}