package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class ImageBut extends AppCompatActivity {
    private ImageButton ImageBoton1;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageb);
        ImageBoton1 = (ImageButton) findViewById(R.id.ImageBoton1);
        mp=MediaPlayer.create(ImageBut.this, R.raw.miau);
        ImageBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
    }
}
