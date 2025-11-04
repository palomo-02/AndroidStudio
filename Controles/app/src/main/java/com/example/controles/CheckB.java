package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class CheckB extends AppCompatActivity {

    CheckBox checkbox1, checkbox2;
    ImageView Imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkb);

        checkbox1=findViewById(R.id.checkBox1);
        checkbox2=findViewById(R.id.checkBox2);
        Imagen=findViewById(R.id.Imagen2);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox1.isChecked()) {
                    checkbox2.setChecked(false);
                    Imagen.setImageResource(R.drawable.perro);
                    Imagen.setVisibility(View.VISIBLE);
                } else {
                    Imagen.setVisibility(View.GONE);
                }
            }
        });
        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox2.isChecked()) {
                    checkbox1.setChecked(false);
                    Imagen.setImageResource(R.drawable.gato);
                    Imagen.setVisibility(View.VISIBLE);
                } else {
                    Imagen.setVisibility(View.GONE);
                }
            }
        });
    }
}
