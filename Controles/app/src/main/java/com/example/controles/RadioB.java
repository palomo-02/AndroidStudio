package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class RadioB extends AppCompatActivity {

    RadioGroup radiogroup;
    RadioButton radiobutton1, radiobutton2;
    ImageView Imagen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiob);

        radiogroup = findViewById(R.id.RadioGroup1);
        radiobutton1 = findViewById(R.id.RadioButton1);
        radiobutton2 = findViewById(R.id.RadioButton2);
        Imagen2 = findViewById(R.id.Imagen2);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RadioButton1) {
                    Imagen2.setImageResource(R.drawable.perro);
                    Imagen2.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.RadioButton2) {
                    Imagen2.setImageResource(R.drawable.gato);
                    Imagen2.setVisibility(View.VISIBLE);
                } else {
                    Imagen2.setVisibility(View.GONE);
                }
            }
        });
    }
}