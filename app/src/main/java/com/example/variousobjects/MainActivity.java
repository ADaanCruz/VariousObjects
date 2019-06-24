package com.example.variousobjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnIng = findViewById(R.id.ingresar);
        btnIng.setOnClickListener(this);
    }
    public void onClick (View view)
    {
        EditText correo = findViewById(R.id.correo);
        String valorCorreo = correo.getText().toString();

        // intent = new Intent(view.getContext(), Menu.class);
        //startActivity(intent);
        if (valorCorreo == "omar.blanco@8w.com.mx") {
            Toast.makeText(this, "Abriendo Segunda Actividad", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(this, "usuario incorrecto", Toast.LENGTH_SHORT).show();
        }
/*
        intent = new Intent(view.getContext(), Menu.class);
        startActivity(intent);
        Toast.makeText(this,"Abriendo Segunda Actividad", Toast.LENGTH_SHORT).show();
*/

    }

}
