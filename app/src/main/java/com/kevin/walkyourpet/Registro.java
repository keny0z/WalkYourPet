package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.walkyourpet.entities.Mascota;
import com.kevin.walkyourpet.entities.Usuario;
import com.kevin.walkyourpet.persistencia.room.DataBaseHelper;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Registro extends AppCompatActivity {

    private Usuario usuario = new Usuario();

    private EditText txtUsuario;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtClave;
    private EditText txtFechaNacimiento;
    private EditText txtCelular;
    private Button btnRegistro;

    //private Date fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        initComponents();

        btnRegistro.setOnClickListener(v -> {
            if(hayCamposVacíos()){
                Toast.makeText(getApplicationContext(),getText(R.string.campos_obligatorios),Toast.LENGTH_LONG).show();
            }else{


                usuario.setUsuario(txtUsuario.getText().toString());
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setApellido(txtApellido.getText().toString());
                usuario.setClave(txtClave.getText().toString());
                usuario.setFechaNacimiento(txtFechaNacimiento.getText().toString());
                usuario.setCelular(txtCelular.getText().toString());

                Usuario usuarioConsultadoUsuario = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByUsuario(usuario.getUsuario());
                Usuario usuarioConsultadoCelular = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByCelular(usuario.getCelular());


                if(usuarioConsultadoUsuario == null && usuarioConsultadoCelular == null){
                    insertarInformacion();
                    Toast.makeText(getApplicationContext(),getText(R.string.informacion_exitosa),Toast.LENGTH_LONG).show();
                    borrarInformacion();
                }else if (usuarioConsultadoUsuario != null){
                    Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_usuario),Toast.LENGTH_LONG).show();
                }else if (usuarioConsultadoCelular != null){
                    Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_celular),Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void initComponents(){

        txtUsuario= findViewById(R.id.txtUsuario);
        txtNombre= findViewById(R.id.txtNombre);
        txtApellido= findViewById(R.id.txtApellido);
        txtClave= findViewById(R.id.txtClave);
        txtFechaNacimiento= findViewById(R.id.txtFechaNacimiento);
        txtCelular= findViewById(R.id.txtCelular);
        btnRegistro= findViewById(R.id.btnAgragar);
    }

    private void iniciarHome(){
        Intent intent = new Intent(getApplicationContext(),Home.class);
        startActivity(intent);
    }

    private boolean hayCamposVacíos(){
        boolean hayVacios= false;
        if(txtUsuario == null || "".equals(txtUsuario.getText().toString()) || txtNombre==null || "".equals(txtNombre.getText().toString()) || txtApellido == null || "".equals(txtApellido.getText().toString()) || txtClave == null || "".equals(txtClave.getText().toString()) || txtFechaNacimiento == null || "".equals(txtFechaNacimiento.getText().toString()) || txtCelular == null || "".equals(txtCelular.getText().toString())){
            hayVacios=true;
        }
        return hayVacios;
    }

    public void mostrarCalendario(View vista)
    {

        DatePickerDialog date= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker vista, int anio, int mes, int dia) {
                txtFechaNacimiento.setText(dia+"/"+(mes+1)+"/"+anio);



            }
        },2021, 0, 1);
        date.show();

    }
    private void insertarInformacion() {
        Observable.fromCallable(()-> {
            DataBaseHelper.getSimpleDB(getApplicationContext()).getUsuarioDAO().create(usuario);
            return usuario;
        }).subscribeOn(Schedulers.computation()).subscribe();
    }
    private void borrarInformacion() {
        usuario = new Usuario();
        txtUsuario.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtClave.setText("");
        txtFechaNacimiento.setText("");
        txtCelular.setText("");
    }
}