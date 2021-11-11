package com.kevin.walkyourpet.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kevin.walkyourpet.persistencia.Tabla;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = Tabla.PASEADOR)
@NoArgsConstructor
public class Paseador {

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

}
