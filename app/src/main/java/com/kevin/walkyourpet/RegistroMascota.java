package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.kevin.walkyourpet.entities.Mascota;

public class RegistroMascota extends AppCompatActivity {

    private Mascota mascota = new Mascota();
    private EditText txtNombreMascota;
    private EditText txtRaza;
    private EditText txtFechaMascota;
    private EditText txtPeso;
    private Button btnAgragar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);
        initComponents();

        /*
        btnAgragar.setOnClickListener(v -> {
            if(hayCamposVacíos()){
                Toast.makeText(getApplicationContext(),getText(R.string.campos_obligatorios),Toast.LENGTH_LONG).show();
            }else{
                mascota.setNombre(txtNombreMascota.getText().toString());
                mascota.setRaza(txtRaza.getText().toString());
                mascota.setFechaNacimiento(txtFechaMascota.getText().toString());
                mascota.setPeso(txtPeso.getText().toString());
                Mascota mascotaConsultada = DataBaseHelper.getDBMainThread(getApplicationContext()).getMascotaDAO().findByNombre(mascota.getNombre());
                if(mascotaConsultada == null){
                    insertarInformacion();
                    Toast.makeText(getApplicationContext(),getText(R.string.informacion_exitosa),Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_mascota),Toast.LENGTH_LONG).show();
                }
            }
        });
         */

    }

    private void initComponents(){

        txtNombreMascota= findViewById(R.id.txtNombreMascota);
        txtRaza= findViewById(R.id.txtRaza);
        txtFechaMascota= findViewById(R.id.txtFechaMascota);
        txtPeso= findViewById(R.id.txtPeso);
        btnAgragar= findViewById(R.id.btnAgragar);

    }
    private boolean hayCamposVacíos(){
        boolean hayVacios= false;
        if(txtNombreMascota == null || "".equals(txtNombreMascota.getText().toString()) || txtRaza==null || "".equals(txtRaza.getText().toString()) || txtFechaMascota == null || "".equals(txtFechaMascota.getText().toString()) || txtPeso == null || "".equals(txtPeso.getText().toString())){
            hayVacios=true;
        }
        return hayVacios;
    }
}