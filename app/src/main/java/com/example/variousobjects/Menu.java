package com.example.variousobjects;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener{
 Intent intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Menu extends AppCompatActivity {


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

        Button btnsigm=(Button)findViewById(R.id.btnsigm);
        btnsigm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

                case R.id.btnimg:
              //  intent= new Intent(this, nomClase.class);
               // startActivity(intent);
                break;

            case R.id.btncamara:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;

            case R.id.btninternet:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;

            case R.id.btngps:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;

            case R.id.btncreditos:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;

            case R.id.btnantm:
                //intent= new Intent(this, nomClase.class);
                //startActivity(intent);
                break;

            case R.id.btnsigg:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;
        }
    }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
