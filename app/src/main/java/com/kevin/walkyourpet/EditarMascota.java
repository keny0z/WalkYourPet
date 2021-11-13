package com.kevin.walkyourpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.walkyourpet.entities.Mascota;
import com.kevin.walkyourpet.entities.Usuario;
import com.kevin.walkyourpet.persistencia.room.DataBaseHelper;
import com.kevin.walkyourpet.sesion.SesionUsuario;

import java.util.ArrayList;
import java.util.List;

public class EditarMascota extends AppCompatActivity {
    EditText txtNombreMascota;
    EditText txtRaza;
    EditText txtFechaMascota;
    EditText txtPeso;
    Button btnActualizar;
    Mascota mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);
        initComponents();
        mascota = (Mascota) getIntent().getExtras().getSerializable("mascota");
        txtNombreMascota.setText(mascota.getNombre());
        txtRaza.setText(mascota.getRaza());
        txtFechaMascota.setText(mascota.getFechaNacimiento());
        txtPeso.setText(mascota.getPeso());

        btnActualizar.setOnClickListener(v -> {
            if(hayCamposVacíos()){
                Toast.makeText(getApplicationContext(),getText(R.string.campos_obligatorios),Toast.LENGTH_LONG).show();
            }else {
                if(nombreCambio()){
                    List<Mascota> mascotaConsultada = consultarMascotaPorNombre(txtNombreMascota.getText().toString());
                    if(mascotaConsultada.size()==0){
                        SesionUsuario.obtenerInstancia().getMascotas().remove(mascota);
                        mascota.setNombre(txtNombreMascota.getText().toString());
                        mascota.setRaza(txtRaza.getText().toString());
                        mascota.setFechaNacimiento(txtFechaMascota.getText().toString());
                        mascota.setPeso(txtPeso.getText().toString());
                        ArrayList<Mascota> nuevasMascotas =  SesionUsuario.obtenerInstancia().getMascotas();
                        nuevasMascotas.add(mascota);
                        SesionUsuario.obtenerInstancia().setMascotas(nuevasMascotas);
                        actualizarUsuario(SesionUsuario.obtenerInstancia());
                        iniciarHome();
                        Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(getApplicationContext(),getText(R.string.ya_existe_mascota),Toast.LENGTH_LONG).show();
                    }

                }else {// si el nombre no cambia se actualiza directamente
                    SesionUsuario.obtenerInstancia().getMascotas().remove(mascota);
                    mascota.setNombre(txtNombreMascota.getText().toString());
                    mascota.setRaza(txtRaza.getText().toString());
                    mascota.setFechaNacimiento(txtFechaMascota.getText().toString());
                    mascota.setPeso(txtPeso.getText().toString());
                    ArrayList<Mascota> nuevasMascotas =  SesionUsuario.obtenerInstancia().getMascotas();
                    nuevasMascotas.add(mascota);
                    SesionUsuario.obtenerInstancia().setMascotas(nuevasMascotas);
                    actualizarUsuario(SesionUsuario.obtenerInstancia());
                    iniciarHome();
                    Toast.makeText(getApplicationContext(),getText(R.string.edicion_exitosa),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void initComponents(){
        txtNombreMascota= findViewById(R.id.txtNombreMascota);
        txtRaza= findViewById(R.id.txtRaza);
        txtFechaMascota= findViewById(R.id.txtFechaMascota);
        txtPeso= findViewById(R.id.txtPeso);
        btnActualizar= findViewById(R.id.btnActualizar);
    }
    private boolean hayCamposVacíos(){
        boolean hayVacios= false;
        if(txtNombreMascota == null || "".equals(txtNombreMascota.getText().toString()) || txtRaza==null || "".equals(txtRaza.getText().toString()) || txtFechaMascota == null || "".equals(txtFechaMascota.getText().toString()) || txtPeso == null || "".equals(txtPeso.getText().toString())){
            hayVacios=true;
        }
        return hayVacios;
    }
    private boolean nombreCambio(){
        if(mascota.getNombre().equals(txtNombreMascota.getText().toString())){
            return  false;
        }
        else {
            return true;
        }
    }
    private List<Mascota> consultarMascotaPorNombre(String nombre){
        List<Mascota> mascotaEncontrada = new ArrayList<>();
        for (Mascota mascota:SesionUsuario.obtenerInstancia().getMascotas()) {
            if (mascota.getNombre().equals(nombre)){
                mascotaEncontrada.add(mascota);
            }
        }
        return mascotaEncontrada;
    }
    private void actualizarUsuario(Usuario usuario){
        DataBaseHelper.getDBMainThread(getApplicationContext()).getUsuarioDAO().update(usuario);
    }
    private void iniciarHome(){
        Intent intent = new Intent(getApplicationContext(),Home.class);
        startActivity(intent);
    }

}