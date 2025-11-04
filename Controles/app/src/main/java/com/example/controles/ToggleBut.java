package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.ToggleButton;

public class ToggleBut extends AppCompatActivity {
    private ToggleButton ToggleBoton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggleb);
        ToggleBoton1 = (ToggleButton) findViewById(R.id.ToggleBoton1);
        ToggleBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ToggleBoton1.isChecked()) {
                    Toast.makeText(ToggleBut.this, "Botón Activado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ToggleBut.this, "Botón Desactivado", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}