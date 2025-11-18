package com.example.dialogo_palomo_zambrano_jose_manuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnDialogo = findViewById(R.id.button);
        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"tarde", "mañana"};
                final boolean[] checkedItems = {false, false};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Selecciona tu cita ");
                builder.setMultiChoiceItems(opciones, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                        String estado = isChecked ? "Marcaste " : "Desmarcaste ";
                        Toast.makeText(MainActivity.this, estado + opciones[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });
    }
}