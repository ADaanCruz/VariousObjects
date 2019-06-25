package com.example.variousobjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvTitle, tvNacionalidad, tvEdad, tvTelefono;
    String titulo, nombre, genero, nacionalidad, fechaDeNacimiento, edad, telefono;
    Button btnAnterior, btnSiguiente;

    Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvTitle = findViewById(R.id.textView_title_welcome);
        tvNacionalidad = findViewById(R.id.textView_nacionality_welcome);
        tvEdad = findViewById(R.id.textView_birthdate_welcome);
        tvTelefono = findViewById(R.id.textView_phone_welcome);
        btnAnterior = findViewById(R.id.button_prev_welcome);
        btnSiguiente = findViewById(R.id.button_next_welcome);

        receivedData();
        structureData();
        writeData();

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(WelcomeActivity.this, DataActivity.class));
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, Menu.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void receivedData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nombre = bundle.getString("name", "");
            genero = bundle.getString("gender", "Ninguno");
            nacionalidad = bundle.getString("nationality", "Ninguno");
            fechaDeNacimiento = bundle.getString("birthdate", "Ninguno");
            telefono = bundle.getString("phone", "Ninguno");
        }
    }

    private void structureData() {
        if (genero.equals("Hombre")) {
            titulo = "Bienvenido, " + nombre;
        } else if (genero.equals("Mujer")) {
            titulo = "Bienvenida, " + nombre;
        }
        nacionalidad = tvNacionalidad.getText().toString() + ": " + nacionalidad + ".";
        edad = String.valueOf(getOld());
        if (edad.equals("1")) {
            edad = tvEdad.getText().toString() + ": "  + edad + " año.";
        } else {
            edad = tvEdad.getText().toString() + ": "  + edad + " años.";
        }
        telefono = tvTelefono.getText().toString() + ": " + telefono + ".";
    }

    private void writeData() {
        tvTitle.setText(titulo);
        tvNacionalidad.setText(nacionalidad);
        tvEdad.setText(edad);
        tvTelefono.setText(telefono);
    }

    private int getOld() {
        date = Calendar.getInstance().getTime();
        int hoy = Integer.parseInt((sdf.format(date)).substring(6));
        int nacimiento = Integer.parseInt(fechaDeNacimiento.substring(6));
        return hoy - nacimiento;
    }
}
