package com.example.myapplicationpreferesias;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class opcionesPreferencia extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carga el XML definido en el paso 1
        addPreferencesFromResource(R.xml.preferencias);
    }
}