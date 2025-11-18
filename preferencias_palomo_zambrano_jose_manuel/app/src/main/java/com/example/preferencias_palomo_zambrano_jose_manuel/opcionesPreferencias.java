package com.example.preferencias_palomo_zambrano_jose_manuel;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class opcionesPreferencias extends PreferenceActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }




}
