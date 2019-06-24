package com.example.variousobjects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InternetActivity extends AppCompatActivity {

    EditText etUri;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        btnEntrar = findViewById(R.id.button_enter_internet);
        etUri = findViewById(R.id.editText_url_internet);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUri.getText().toString().contains("https://")) {

                } else {
                    Toast.makeText(InternetActivity.this, "Ingresa el https://", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
