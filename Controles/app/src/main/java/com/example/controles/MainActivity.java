package com.example.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void irATextView (View view) {
        Intent intent1 = new Intent(this, TextV.class);
        startActivity(intent1);
    }
    public void irAButton (View view) {
        Intent intent2 = new Intent(this, But.class);
        startActivity(intent2);
    }
    public void irAToggleButton (View view) {
        Intent intent3 = new Intent(this, ToggleBut.class);
        startActivity(intent3);
    }
    public void irAImageButton (View view) {
        Intent intent4 = new Intent(this, ImageBut.class);
        startActivity(intent4);
    }
    public void irAEditText (View view) {
        Intent intent5 = new Intent(this, EditT.class);
        startActivity(intent5);
    }
    public void irASpinner (View view) {
        Intent intent6 = new Intent(this, Spin.class);
        startActivity(intent6);
    }
    public void irACheckBox (View view) {
        Intent intent7 = new Intent(this, CheckB.class);
        startActivity(intent7);
    }
    public void irARadioButton (View view) {
        Intent intent8 = new Intent(this, RadioB.class);
        startActivity(intent8);
    }
    public void irASwitch (View view) {
        Intent intent9 = new Intent(this, Swit.class);
        startActivity(intent9);
    }
    public void irASeekBar (View view) {
        Intent intent10 = new Intent(this, SeekB.class);
        startActivity(intent10);
    }
    public void irARatingBar (View view) {
        Intent intent11 = new Intent(this, RatingB.class);
        startActivity(intent11);
    }
    public void irAProgressBar (View view) {
        Intent intent12 = new Intent(this, ProgressB.class);
        startActivity(intent12);
    }
}