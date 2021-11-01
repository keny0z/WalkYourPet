package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kevin.walkyourpet.entities.Usuario;
import com.kevin.walkyourpet.persistencia.room.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    private Usuario usuario = new Usuario();

    TextView tvLinkRegistro;
    Button btnIniciarSesion;

    EditText etUsuario;
    EditText etClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        tvLinkRegistro.setOnClickListener(v -> {
            iniciarRegistro();
        });

        btnIniciarSesion.setOnClickListener(v -> {
            //iniciarHome();
            if(hayCamposVacíos()){
                Toast.makeText(getApplicationContext(),getText(R.string.campos_obligatorios),Toast.LENGTH_LONG).show();
            }else {
                usuario.setUsuario(etUsuario.getText().toString());
                //usuario.setClave(etClave.getText().toString());
                Usuario usuarioConsultadoUsuario = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByUsuario(usuario.getUsuario());
                if (usuarioConsultadoUsuario != null){
                    if (usuarioConsultadoUsuario.getClave().equals(etClave.getText().toString())){
                        iniciarHome();
                    }else{
                        Toast.makeText(getApplicationContext(),getText(R.string.clave_incorrecta),Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),getText(R.string.usuario_no_existe),Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private void initComponents(){
        tvLinkRegistro= findViewById(R.id.tvLinkRegistro);
        btnIniciarSesion= findViewById(R.id.btnIniciarSesion);
        etUsuario= findViewById(R.id.etUsuario);
        etClave= findViewById(R.id.etClave);
    }

    private void iniciarRegistro(){
        Intent intent = new Intent(getApplicationContext(),Registro.class);
        startActivity(intent);
    }

    private void iniciarHome(){
        Intent intent = new Intent(getApplicationContext(),Home.class);
        startActivity(intent);
    }

    private boolean hayCamposVacíos(){
        boolean hayVacios= false;
        if(etUsuario == null || "".equals(etUsuario.getText().toString()) || etClave==null || "".equals(etClave.getText().toString())){
            hayVacios=true;
        }
        return hayVacios;
    }
}