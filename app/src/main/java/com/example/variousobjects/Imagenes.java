package com.example.variousobjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Imagenes extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes2);

        Button btnantm=(Button)findViewById(R.id.btnanti);
        btnantm.setOnClickListener(this);

        Button btnsigm=(Button)findViewById(R.id.btnsigi);
        btnsigm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnanti:
                intent= new Intent(this, Menu.class);
                startActivity(intent);
                break;

            case R.id.btnsigi:
                  intent= new Intent(this, camara.class);
                  startActivity(intent);
                break;
       }
    }
}
