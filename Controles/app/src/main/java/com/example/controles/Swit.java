package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class Swit extends AppCompatActivity {

     Switch Interruptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swit);

        Switch Interruptor=(Switch)findViewById(R.id.Switch1);
        Interruptor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean pulsado) {
                if (pulsado) {
                    Toast.makeText(Swit.this, "Tienes acceso gratuito", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Swit.this, "No tienes acceso gratuito", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
