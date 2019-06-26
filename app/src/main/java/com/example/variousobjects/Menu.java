package com.example.variousobjects;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnimg=(Button)findViewById(R.id.btnimg);
        btnimg.setOnClickListener(this);

        Button btncamara=(Button)findViewById(R.id.btncamara);
        btncamara.setOnClickListener(this);

        Button btninternet=(Button)findViewById(R.id.btninternet);
        btninternet.setOnClickListener(this);

        Button btngps=(Button)findViewById(R.id.btngps);
        btngps.setOnClickListener(this);

        Button btncreditos=(Button)findViewById(R.id.btncreditos);
        btncreditos.setOnClickListener(this);

        Button btnantm=(Button)findViewById(R.id.btnantm);
        btnantm.setOnClickListener(this);

        Button btnsigm=(Button)findViewById(R.id.btnsalm);
        btnsigm.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnimg:
                  intent= new Intent(this, Imagenes.class);
                 startActivity(intent);
                break;

            case R.id.btncamara:
                  intent= new Intent(this, camara.class);
                  startActivity(intent);
                break;

            case R.id.btninternet:
                  intent= new Intent(this, Internet.class);
                 startActivity(intent);
                break;

            case R.id.btngps:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;

            case R.id.btncreditos:
                  intent= new Intent(this, Creditos.class);
                 startActivity(intent);
                break;

            case R.id.btnantm:
                intent= new Intent(Menu.this, DataActivity.class);
                finish();
                startActivity(intent);
                break;

            case R.id.btnsalm:
                finish();
                break;
        }
    }
}
