package com.example.practica_04_11_2025;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class imagenCasas extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceStatte) {
        super.onCreate(savedInstanceStatte);
        setContentView(R.layout.intentcasas);

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {


        String mensaje = "";
        switch (item.getItemId()) {
            case R.id.opcionM_1:

                mensaje = "has elegido madrid";
                break;

              default:


                return super.onOptionsItemSelected(item);
        }

        //Toast.makeText( context: this, mensaje, Toast.LENGTH_LONG).show();



        return true;
    }




}
