package com.example.myapplicationpreferesias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat; // Importante para notificaciones

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ========================================================================
        // BLOQUE 1: PREFERENCIAS (Slides 2-9)
        // ========================================================================

     // BOTÓN 1: IR A AJUSTES (Lanza la PreferenceActivity) [cite: 65]
        Button btnPreferencias = findViewById(R.id.btnPreferencias);
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent explícito para abrir la pantalla de ajustes
                Intent intent = new Intent(MainActivity.this, opcionesPreferencia.class);
                startActivity(intent);
            }
        });

      // BOTÓN 2: LEER AJUSTES (Lee SharedPreferences) [cite: 71-80]
        Button btnObtener = findViewById(R.id.btnObtenerPreferencias);
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos el fichero de preferencias por defecto
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                // Leemos los valores usando las "keys" definidas en preferencias.xml
                boolean notif = pref.getBoolean("notificaciones_activas", false);
                String usuario = pref.getString("nombre_usuario", "Invitado");
                String sistema = pref.getString("pref_ejemplo_lista", "Sin selección");

                String mensaje = "Notificaciones: " + notif + "\nUsuario: " + usuario + "\nSistema: " + sistema;
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });

        // ========================================================================
        // BLOQUE 2: DIÁLOGOS (Slides 13-17)
        // ========================================================================

   // BOTÓN 3: DIÁLOGO SIMPLE (Botones Positivo/Negativo) [cite: 192-218]
        Button btnDialogo = findViewById(R.id.btnDialogo);
        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("OPCIONES DISPONIBLES")
                        .setMessage("ELIGE UNA OPCIÓN")
                        .setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("POSITIVO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "Pulsaste SI", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("NEGATIVO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "Pulsaste NO", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("NEUTRO", null); // null si no hace nada
                builder.create().show();
            }
        });

    // BOTÓN 4: DIÁLOGO LISTA SIMPLE (Clic y selecciona) [cite: 228-231]
        Button btnDialogoLista = findViewById(R.id.btnDialogoLista);
        btnDialogoLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"Opción A", "Opción B", "Opción C"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("ELIGE UNA OPCIÓN");
                builder.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(MainActivity.this, "Elegiste: " + opciones[item], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });
// BOTÓN 5: SELECCIÓN ÚNICA (Radio Buttons) [cite: 241]
        Button btnUnica = findViewById(R.id.btnSeleccionUnica);
        btnUnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"Windows", "Linux", "Mac"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Elige un sistema (Único)");
                // El '0' marca la primera opción por defecto
                builder.setSingleChoiceItems(opciones, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Seleccionado: " + opciones[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        // BOTÓN 6: SELECCIÓN MÚLTIPLE (Checkboxes) [cite: 241]
        Button btnMultiple = findViewById(R.id.btnSeleccionMultiple);
        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"Wifi", "Bluetooth", "GPS"};
                final boolean[] checkedItems = {false, false, false}; // Estado inicial

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Elige opciones (Múltiple)");
                builder.setMultiChoiceItems(opciones, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked; // Guardar estado
                        String estado = isChecked ? "Marcaste " : "Desmarcaste ";
                        Toast.makeText(MainActivity.this, estado + opciones[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        // ========================================================================
        // BLOQUE 3: NOTIFICACIONES (Slides 22-24)
        // ========================================================================

  // BOTÓN 7: LANZAR NOTIFICACIÓN [cite: 390-420]
        Button btnNotif = findViewById(R.id.btnNotificacion);
        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                String canalID = "Canal_ID";

                // A. Crear Canal (Obligatorio en Android 8+)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel canal = new NotificationChannel(canalID, "Canal Ejemplo", NotificationManager.IMPORTANCE_DEFAULT);
                    notificador.createNotificationChannel(canal);
                }

                // B. Configurar Aspecto Visual
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, canalID);
                builder.setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle("MENSAJE DE ALERTA")
                        .setContentText("Notificación: Pulsa para ir al destino.")
                        .setTicker("AVISO DE NOTIFICACIÓN");

                // *** CORRECCIÓN PARA ICONO GRANDE (Evita el crash en Xiaomi/Samsung) ***
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

              // C. Configurar Navegación (TaskStackBuilder) [cite: 410-412]
                // Esto asegura que al dar "Atrás" en Destino, volvemos a MainActivity
                Intent intent = new Intent(MainActivity.this, Destino.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
                stackBuilder.addParentStack(Destino.class);
                stackBuilder.addNextIntent(intent);

                // D. PendingIntent (Permiso para ejecutar el intent más tarde)
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
                );
                builder.setContentIntent(resultPendingIntent);
                builder.setAutoCancel(true); // La notificación desaparece al tocarla

                // E. Mostrar
                notificador.notify(1, builder.build());
            }
        });
    }
}