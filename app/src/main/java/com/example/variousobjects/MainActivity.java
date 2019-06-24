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
        Button btnClo = findViewById(R.id.salir);
        btnClo.setOnClickListener(this);
    }
    public void onClick (View view)
    {
        EditText correo = findViewById(R.id.correo);
        EditText contraseña = findViewById(R.id.password);

        String valorCorreo = correo.getText().toString();
        String valorContraseña = contraseña.getText().toString();

        if ((valorCorreo.equals("omar.blanco@8w.com.mx")||valorCorreo.equals("lourdesvega21@hotmail.com")||valorCorreo.equals("djdaan86@gmail.com "))&&valorContraseña.equals("123456"))
        {
            intent = new Intent(view.getContext(), Menu.class);
            startActivity(intent);
            Toast.makeText(this,"Abriendo Segunda Actividad", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario y/o Contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }

    }

}
