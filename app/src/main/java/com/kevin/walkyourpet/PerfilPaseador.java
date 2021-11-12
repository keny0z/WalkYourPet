package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.walkyourpet.entities.Paseador;

public class PerfilPaseador extends AppCompatActivity {
    ImageView ivImagen;
    TextView tvUsuario;
    TextView tvNombre;
    TextView tvApellido;
    TextView tvCelular;
    Button btnContactar;
    Paseador paseador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_paseador);

        initComponents();
        paseador= (Paseador) getIntent().getExtras().getSerializable("paseador");
        ivImagen.setImageResource(paseador.getImagen());
        tvUsuario.setText(paseador.getUsuario());
        tvNombre.setText("Nombre: "+paseador.getNombre());
        tvApellido.setText("Apellido: "+paseador.getApellido());
        tvCelular.setText("Celular: "+paseador.getCelular());

    }

    private void initComponents(){
        ivImagen= findViewById(R.id.ivImagen);
        tvUsuario= findViewById(R.id.tvUsuario);
        tvNombre= findViewById(R.id.tvNombre);
        tvApellido= findViewById(R.id.tvApellido);
        tvCelular= findViewById(R.id.tvCelular);
        btnContactar= findViewById(R.id.btnContactar);
    }
}