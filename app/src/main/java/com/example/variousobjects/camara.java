package com.example.variousobjects;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class camara extends AppCompatActivity implements View.OnClickListener  {
    Intent intent;
    Button btn;
    ImageView imagen;
    Intent i;
    final  static int cons =0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        Button btnantm=(Button)findViewById(R.id.btnanti);
        btnantm.setOnClickListener(this);

        Button btnsigm=(Button)findViewById(R.id.btnsigi);
        btnsigm.setOnClickListener(this);
        checkCameraPermission();
        init();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnanti:
                intent= new Intent(this, Menu.class);
                startActivity(intent);
                break;

            case R.id.btnsigi:
                //  intent= new Intent(this, nomClase.class);
                // startActivity(intent);
                break;
            case R.id.btnCaptura:
                i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cons);
                break;
        }


    }
    public void init(){
        btn = (Button)findViewById(R.id.btnCaptura);
        btn.setOnClickListener(this);

        imagen = (ImageView)findViewById(R.id.imagen);
    }

    private void checkCameraPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para la camara!.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 225);
        } else {
            Log.i("Mensaje", "Tienes permiso para usar la camara.");
        }
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode== Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            bmp = (Bitmap)ext.get("data");
            imagen.setImageBitmap(bmp);
        }
    }
}
