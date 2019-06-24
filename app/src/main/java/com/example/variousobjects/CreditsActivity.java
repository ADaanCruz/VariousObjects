package com.example.variousobjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {

    TextView tvTitulo, tvCreditos;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tvTitulo = findViewById(R.id.textView_title_credits);
        tvCreditos = findViewById(R.id.textView_text_credits);
        btnRegresar = findViewById(R.id.button_atras_credits);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(CreditsActivity.this, Menu.class));
            }
        });
    }
}