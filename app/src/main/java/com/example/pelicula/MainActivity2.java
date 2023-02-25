package com.example.pelicula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText ET_Mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ET_Mensaje = findViewById(R.id.ET_Mensaje);
        String CorreoRecibido = getIntent().getStringExtra("mensaje");

        ET_Mensaje.setText(CorreoRecibido);
    }
}