package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.walkyourpet.entities.Usuario;
import com.kevin.walkyourpet.persistencia.room.DataBaseHelper;
import com.kevin.walkyourpet.sesion.SesionUsuario;

public class EditarUsusario extends AppCompatActivity {
    private EditText txtUsuario;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtClave;
    private EditText txtFechaNacimiento;
    private EditText txtCelular;
    private Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_ususario);
        initComponents();
        txtUsuario.setText(SesionUsuario.obtenerInstancia().getUsuario());
        txtNombre.setText(SesionUsuario.obtenerInstancia().getNombre());
        txtApellido.setText(SesionUsuario.obtenerInstancia().getApellido());
        txtClave.setText(SesionUsuario.obtenerInstancia().getClave());
        txtFechaNacimiento.setText(SesionUsuario.obtenerInstancia().getFechaNacimiento());
        txtCelular.setText(SesionUsuario.obtenerInstancia().getCelular());


        btnActualizar.setOnClickListener(v -> {
            if(hayCamposVacíos()){
                Toast.makeText(getApplicationContext(),getText(R.string.campos_obligatorios),Toast.LENGTH_LONG).show();
            }else {

                if(usuarioCambio() || celularCambio()){ //si se cambia el usuario o el celular toca hacer validadciones
                    if (usuarioCambio() && celularCambio()){
                        Usuario usuarioConsultadoUsuario = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByUsuario(txtUsuario.getText().toString());
                        Usuario usuarioConsultadoCelular = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByCelular(txtCelular.getText().toString());
                        if(usuarioConsultadoUsuario == null && usuarioConsultadoCelular == null){
                            SesionUsuario.obtenerInstancia().setUsuario(txtUsuario.getText().toString());
                            SesionUsuario.obtenerInstancia().setNombre(txtNombre.getText().toString());
                            SesionUsuario.obtenerInstancia().setApellido(txtApellido.getText().toString());
                            SesionUsuario.obtenerInstancia().setClave(txtClave.getText().toString());
                            SesionUsuario.obtenerInstancia().setFechaNacimiento(txtFechaNacimiento.getText().toString());
                            SesionUsuario.obtenerInstancia().setCelular(txtCelular.getText().toString());
                            editarUsuario(SesionUsuario.obtenerInstancia());
                            Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();
                        }else if (usuarioConsultadoUsuario != null){
                            Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_usuario),Toast.LENGTH_LONG).show();
                        }else if (usuarioConsultadoCelular != null){
                            Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_celular),Toast.LENGTH_LONG).show();
                        }

                        //consultar ambos
                    }else if(usuarioCambio()){
                        Usuario usuarioConsultadoUsuario = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByUsuario(txtUsuario.getText().toString());
                        if(usuarioConsultadoUsuario==null){
                            SesionUsuario.obtenerInstancia().setUsuario(txtUsuario.getText().toString());
                            SesionUsuario.obtenerInstancia().setNombre(txtNombre.getText().toString());
                            SesionUsuario.obtenerInstancia().setApellido(txtApellido.getText().toString());
                            SesionUsuario.obtenerInstancia().setClave(txtClave.getText().toString());
                            SesionUsuario.obtenerInstancia().setFechaNacimiento(txtFechaNacimiento.getText().toString());
                            SesionUsuario.obtenerInstancia().setCelular(txtCelular.getText().toString());
                            editarUsuario(SesionUsuario.obtenerInstancia());
                            Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_usuario),Toast.LENGTH_LONG).show();
                        }
                    }else if(celularCambio()){
                        Usuario usuarioConsultadoCelular = DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().findByCelular(txtCelular.getText().toString());
                        if(usuarioConsultadoCelular==null){
                            SesionUsuario.obtenerInstancia().setUsuario(txtUsuario.getText().toString());
                            SesionUsuario.obtenerInstancia().setNombre(txtNombre.getText().toString());
                            SesionUsuario.obtenerInstancia().setApellido(txtApellido.getText().toString());
                            SesionUsuario.obtenerInstancia().setClave(txtClave.getText().toString());
                            SesionUsuario.obtenerInstancia().setFechaNacimiento(txtFechaNacimiento.getText().toString());
                            SesionUsuario.obtenerInstancia().setCelular(txtCelular.getText().toString());
                            editarUsuario(SesionUsuario.obtenerInstancia());
                            Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_celular),Toast.LENGTH_LONG).show();
                        }
                    }


                }else { //si no se cambia ninguno se registra directamente sin hacer ninguna validacion
                    SesionUsuario.obtenerInstancia().setUsuario(txtUsuario.getText().toString());
                    SesionUsuario.obtenerInstancia().setNombre(txtNombre.getText().toString());
                    SesionUsuario.obtenerInstancia().setApellido(txtApellido.getText().toString());
                    SesionUsuario.obtenerInstancia().setClave(txtClave.getText().toString());
                    SesionUsuario.obtenerInstancia().setFechaNacimiento(txtFechaNacimiento.getText().toString());
                    SesionUsuario.obtenerInstancia().setCelular(txtCelular.getText().toString());
                    editarUsuario(SesionUsuario.obtenerInstancia());
                    Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();
                }

            }
        });


        /*
        btnActualizar.setOnClickListener(v -> {
            if(hayCamposVacíos()){
                Toast.makeText(getApplicationContext(),getText(R.string.campos_obligatorios),Toast.LENGTH_LONG).show();
            }else {
                SesionUsuario.obtenerInstancia().setUsuario(txtUsuario.getText().toString());
                SesionUsuario.obtenerInstancia().setNombre(txtNombre.getText().toString());
                SesionUsuario.obtenerInstancia().setApellido(txtApellido.getText().toString());
                SesionUsuario.obtenerInstancia().setClave(txtClave.getText().toString());
                SesionUsuario.obtenerInstancia().setFechaNacimiento(txtFechaNacimiento.getText().toString());
                SesionUsuario.obtenerInstancia().setCelular(txtCelular.getText().toString());
                editarUsuario(SesionUsuario.obtenerInstancia());
                Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();
            }
        });

         */


    }
    private void initComponents(){

        txtUsuario= findViewById(R.id.txtUsuario);
        txtNombre= findViewById(R.id.txtNombre);
        txtApellido= findViewById(R.id.txtApellido);
        txtClave= findViewById(R.id.txtClave);
        txtFechaNacimiento= findViewById(R.id.txtFechaNacimiento);
        txtCelular= findViewById(R.id.txtCelular);
        btnActualizar= findViewById(R.id.btnActualizar);
    }
    private boolean hayCamposVacíos(){
        boolean hayVacios= false;
        if(txtUsuario == null || "".equals(txtUsuario.getText().toString()) || txtNombre==null || "".equals(txtNombre.getText().toString()) || txtApellido == null || "".equals(txtApellido.getText().toString()) || txtClave == null || "".equals(txtClave.getText().toString()) || txtFechaNacimiento == null || "".equals(txtFechaNacimiento.getText().toString()) || txtCelular == null || "".equals(txtCelular.getText().toString())){
            hayVacios=true;
        }
        return hayVacios;
    }
    private void editarUsuario(Usuario usuario){
        DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().update(usuario);
    }
    private boolean usuarioCambio(){
        if(SesionUsuario.obtenerInstancia().getUsuario().equals(txtUsuario.getText().toString())){
            return  false;
        }
        else {
            return true;
        }
    }
    private boolean celularCambio(){
        if (SesionUsuario.obtenerInstancia().getCelular().equals(txtCelular.getText().toString())){
            return false;
        }
        else {
            return true;
        }
    }
}