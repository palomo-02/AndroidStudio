package com.example.aplicacionrepaso_palomo_zambrano_jose_manuel;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class recompensaPuzzle extends AppCompatActivity {
    private VideoView videoView;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_recompensa);

        videoView = findViewById(R.id.videoView3);

        try {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.polloflamenco;
            videoView.setVideoURI(Uri.parse(path));
            videoView.start();

            videoView.setOnCompletionListener(mp -> {
                videoView.seekTo(0);
                videoView.start();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }




    }



}
