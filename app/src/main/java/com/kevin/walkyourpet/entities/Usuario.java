package com.kevin.walkyourpet.entities;




import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kevin.walkyourpet.persistencia.Tabla;


import java.lang.reflect.Type;
import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = Tabla.USUARIO)
@NoArgsConstructor
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private Integer id;
    @ColumnInfo(name="usuario")
    private String usuario;
    @ColumnInfo(name="nombre")
    private String nombre;
    @ColumnInfo(name="apellido")
    private String apellido;
    @ColumnInfo(name="clave")
    private String clave;
    @ColumnInfo(name="fechaNacimiento")
    private String fechaNacimiento;
    @ColumnInfo(name="celular")
    private String celular;
    @ColumnInfo(name="latitud")
    private Double latitud;
    @ColumnInfo(name="longitud")
    private Double longitud;
    @ColumnInfo(name="mascotas")
    private ArrayList<Mascota> mascotas = new ArrayList<>();
}
