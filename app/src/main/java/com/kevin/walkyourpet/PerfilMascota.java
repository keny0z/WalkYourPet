package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.walkyourpet.entities.Mascota;

public class PerfilMascota extends AppCompatActivity {
    ImageView imagenMascota;
    TextView tvNombre;
    TextView tvRaza;
    TextView tvFechaNacimiento;
    TextView tvPeso;
    Button btnEditarMascota;
    Mascota mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_mascota);
        initComponents();
        mascota = (Mascota) getIntent().getExtras().getSerializable("mascota");
        imagenMascota.setImageResource(mascota.getImagen());
        tvNombre.setText(mascota.getNombre());
        tvRaza.setText("Raza: "+mascota.getRaza());
        tvFechaNacimiento.setText("Nacimiento: "+mascota.getFechaNacimiento());
        tvPeso.setText("Peso: "+mascota.getPeso()+" kg");


    }
    private void initComponents(){
        imagenMascota= findViewById(R.id.imagenMascota);
        tvNombre= findViewById(R.id.tvNombre);
        tvRaza= findViewById(R.id.tvRaza);
        tvFechaNacimiento= findViewById(R.id.tvFechaNacimiento);
        tvPeso= findViewById(R.id.tvPeso);
        btnEditarMascota= findViewById(R.id.btnEditarMascota);
    }
}