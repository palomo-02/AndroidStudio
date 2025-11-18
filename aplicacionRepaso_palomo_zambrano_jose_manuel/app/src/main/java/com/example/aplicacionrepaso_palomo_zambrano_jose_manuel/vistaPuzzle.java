package com.example.aplicacionrepaso_palomo_zambrano_jose_manuel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class vistaPuzzle extends AppCompatActivity {

    private ImageView cabezaPepe;
    private ImageView torsoPollo;
    private boolean cabezaColocada = false;
    private float dX, dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle);

        cabezaPepe = findViewById(R.id.cabezaPepe);
        torsoPollo = findViewById(R.id.torsoPollo);

        setupPuzzle();
    }

    private void setupPuzzle() {
        cabezaPepe.post(() -> {
            cabezaPepe.setOnTouchListener((v, event) -> {
                if (cabezaColocada) return false;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX() + dX);
                        v.setY(event.getRawY() + dY);
                        break;

                    case MotionEvent.ACTION_UP:
                        checkPuzzleCompletion();
                        break;
                }
                return true;
            });
        });
    }

    private void checkPuzzleCompletion() {
        float cabezaCenterX = cabezaPepe.getX() + cabezaPepe.getWidth() / 2f;
        float cabezaCenterY = cabezaPepe.getY() + cabezaPepe.getHeight() / 2f;
        float torsoCenterX = torsoPollo.getX() + torsoPollo.getWidth() / 2f;
        float torsoCenterY = torsoPollo.getY() + torsoPollo.getHeight() / 2f;

        float dx = cabezaCenterX - torsoCenterX;
        float dy = cabezaCenterY - torsoCenterY;
        float distancia = (float) Math.sqrt(dx * dx + dy * dy);

        if (distancia < 150) {
            cabezaColocada = true;

            float finalX = torsoPollo.getX() + (torsoPollo.getWidth() - cabezaPepe.getWidth()) / 2f;
            float finalY = torsoPollo.getY() - cabezaPepe.getHeight() + 40f;

            cabezaPepe.setX(finalX);
            cabezaPepe.setY(finalY);

            cabezaPepe.setOnTouchListener(null);


            Intent intent2 = new Intent(this, recompensaPuzzle.class);
            startActivity(intent2);




        }
    }
}
