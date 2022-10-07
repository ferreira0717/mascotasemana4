package com.example.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Contacto extends AppCompatActivity {
    private TextView nombre,correo,mensaje;
    private Button enviar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre = findViewById(R.id.editTextnombre);
        correo = findViewById(R.id.editTextcorreo);
        mensaje = findViewById(R.id.editTextmensaje);
        enviar = findViewById(R.id.button);

        toolbar = findViewById(R.id.toolbarcontacto);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(view -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

        enviar.setOnClickListener(v -> {

        });

    }
}