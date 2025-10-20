package com.example.tarea7;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private VideoView videoView;
    private TextView estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar todas las vistas
        estado = findViewById(R.id.estado); // Asegúrate de que este ID existe en tu XML
        videoView = findViewById(R.id.videoView);

        // Inicializar MediaPlayer con manejo de errores
        try {
            mp = MediaPlayer.create(this, R.raw.audiosecreto);
            if (mp != null) {
                estado.setText("MediaPlayer listo");
            } else {
                estado.setText("Error: Audio no encontrado");
            }
        } catch (Exception e) {
            estado.setText("Error cargando audio");
            e.printStackTrace();
        }

        // Configurar VideoView
        try {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
            videoView.setVideoURI(Uri.parse(path));
        } catch (Exception e) {
            estado.setText("Error cargando video");
            e.printStackTrace();
        }
    }

    public void reproducirAudio(View view) {
        if (mp != null) {
            mp.start();
            estado.setText("Reproduciendo audio");
        }
    }

    public void pausarAudio(View view) {
        if (mp != null && mp.isPlaying()) {
            mp.pause();
            estado.setText("Audio pausado");
        }
    }

    public void detenerAudio(View view) {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.stop();
            }
            mp.release();
            mp = null;

            // Recrear el MediaPlayer
            try {
                mp = MediaPlayer.create(this, R.raw.audiosecreto);
                estado.setText("Audio detenido");
            } catch (Exception e) {
                estado.setText("Error recreando audio");
                e.printStackTrace();
            }
        }
    }

    public void reproducirVideo(View view) {
        if (videoView != null) {
            videoView.start();
            estado.setText("Reproduciendo video");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberar recursos
        if (mp != null) {
            mp.release();
            mp = null;
        }
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }
}