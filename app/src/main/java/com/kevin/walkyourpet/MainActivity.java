package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLinkRegistro;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        tvLinkRegistro.setOnClickListener(v -> {
            iniciarRegistro();
        });

        btnIniciarSesion.setOnClickListener(v -> {
            iniciarHome();
        });
    }

    private void initComponents(){
        tvLinkRegistro= findViewById(R.id.tvLinkRegistro);
        btnIniciarSesion= findViewById(R.id.btnIniciarSesion);
    }

    private void iniciarRegistro(){
        Intent intent = new Intent(getApplicationContext(),Registro.class);
        startActivity(intent);
    }

    private void iniciarHome(){
        Intent intent = new Intent(getApplicationContext(),Home.class);
        startActivity(intent);
    }
}