package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import static android.view.animation.AnimationUtils.*;

public class TextV extends AppCompatActivity {
    private Animation mianimacion;
    private TextView textoanimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textv);
        mianimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        mianimacion.setRepeatMode(Animation.RESTART);
        mianimacion.setRepeatCount(10);
        textoanimado=findViewById(R.id.textoanimado);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textoanimado.startAnimation(mianimacion);
    }
}

