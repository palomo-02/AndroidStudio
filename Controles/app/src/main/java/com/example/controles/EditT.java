package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class EditT extends AppCompatActivity {
    private EditText contacto;
    private EditText teléfono;
    private TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editt);

        contacto=findViewById(R.id.Contacto);
        teléfono=findViewById(R.id.Teléfono);
        respuesta=findViewById(R.id.respuesta);

        TextWatcher watcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!contacto.getText().toString().isEmpty()&&!teléfono.getText().toString().isEmpty()) {
                    String resp = "El número de " + contacto.getText().toString() + " es: " + teléfono.getText().toString();
                    respuesta.setText(resp);
                }
                else {
                    respuesta.setText("");
                }
            }

        };
        contacto.addTextChangedListener(watcher);
        teléfono.addTextChangedListener(watcher);
    }
 }
