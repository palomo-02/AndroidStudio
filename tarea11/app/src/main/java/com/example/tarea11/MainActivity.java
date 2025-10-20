package com.example.tarea11;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView tx, ty, tz, status;
    private View colorIndicator;
    private View rootLayout;

    private long lastShakeTime = 0;
    private static final int SHAKE_THRESHOLD = 12; // m/s²
    private static final int SHAKE_TIMEOUT = 1000; // ms

    // Para filtrado de ruido
    private static final float ALPHA = 0.8f;
    private float[] filteredValues = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        // Inicializar vistas
        tx = findViewById(R.id.tx);
        ty = findViewById(R.id.ty);
        tz = findViewById(R.id.tz);
        status = findViewById(R.id.status);
        colorIndicator = findViewById(R.id.colorIndicator);
        rootLayout = findViewById(R.id.rootLayout);

        // Inicializar SensorManager - CORREGIDO
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Verificar si el dispositivo tiene acelerómetro
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer == null) {
                status.setText("Estado: Acelerómetro no disponible");
                Toast.makeText(AcelerometroActivity.this, "Este dispositivo no tiene acelerómetro", Toast.LENGTH_LONG).show();
            }
        }

        // Inicializar valores filtrados
        filteredValues[0] = 0;
        filteredValues[1] = 0;
        filteredValues[2] = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Registrar el listener solo si el sensor está disponible
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            status.setText("Estado: Monitoreando...");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Anular registro para ahorrar batería
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Aplicar filtro paso bajo para reducir ruido
            filteredValues[0] = applyLowPassFilter(event.values[0], filteredValues[0]);
            filteredValues[1] = applyLowPassFilter(event.values[1], filteredValues[1]);
            filteredValues[2] = applyLowPassFilter(event.values[2], filteredValues[2]);

            float x = filteredValues[0];
            float y = filteredValues[1];
            float z = filteredValues[2];

            // Actualizar TextView con los valores
            tx.setText(String.format("X: %.2f m/s²", x));
            ty.setText(String.format("Y: %.2f m/s²", y));
            tz.setText(String.format("Z: %.2f m/s²", z));

            // Calcular magnitud del vector aceleración
            double magnitude = Math.sqrt(x * x + y * y + z * z);
            long currentTime = System.currentTimeMillis();

            // Detectar shake
            if (magnitude > SHAKE_THRESHOLD && (currentTime - lastShakeTime) > SHAKE_TIMEOUT) {
                lastShakeTime = currentTime;
                onShakeDetected();
            }

            // Actualizar estado según la magnitud
            updateStatus(magnitude);
        }
    }

    private float applyLowPassFilter(float current, float filtered) {
        return ALPHA * filtered + (1 - ALPHA) * current;
    }

    private void onShakeDetected() {
        // Cambiar color del indicador
        int randomColor = Color.rgb(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
        colorIndicator.setBackgroundColor(randomColor);

        // Cambiar color de fondo suave
        rootLayout.setBackgroundColor(Color.argb(30, Color.red(randomColor),
                Color.green(randomColor), Color.blue(randomColor)));

        // Mostrar Toast - CORREGIDO
        Toast.makeText(AcelerometroActivity.this, "¡Shake detectado!", Toast.LENGTH_SHORT).show();

        // Actualizar estado
        status.setText("Estado: ¡SHAKE DETECTADO!");
    }

    private void updateStatus(double magnitude) {
        if (magnitude > SHAKE_THRESHOLD) {
            status.setText("Estado: Movimiento fuerte");
        } else if (magnitude > 8) {
            status.setText("Estado: Movimiento moderado");
        } else {
            status.setText("Estado: Normal");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Puedes manejar cambios en la precisión si es necesario
        switch (accuracy) {
            case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                // Alta precisión
                break;
            case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                // Precisión media
                break;
            case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                // Baja precisión
                break;
            case SensorManager.SENSOR_STATUS_UNRELIABLE:
                // Datos no confiables
                status.setText("Estado: Datos no confiables");
                break;
        }
    }
}