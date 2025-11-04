package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class Spin extends AppCompatActivity {
    Spinner Spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);

        Spinner1=(Spinner)findViewById(R.id.Spinner1);
        String[] valores={"1º SMR", "2º SMR", "1º DAW", "2º DAW", "1º DAM", "2º DAM"};
        Spinner1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        Spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
