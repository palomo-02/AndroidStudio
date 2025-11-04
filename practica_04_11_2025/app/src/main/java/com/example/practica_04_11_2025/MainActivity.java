package com.example.practica_04_11_2025;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.opcionM_1:

                Intent intent1 = new Intent(this, imagenCasas.class);
                startActivity(intent1);

                break;

            default:


                return super.onOptionsItemSelected(item);
        }

        //Toast.makeText( context: this, mensaje, Toast.LENGTH_LONG).show();



        return true;
    }






}