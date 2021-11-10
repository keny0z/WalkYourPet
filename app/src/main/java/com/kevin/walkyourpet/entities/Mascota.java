package com.kevin.walkyourpet.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kevin.walkyourpet.persistencia.Tabla;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = Tabla.MASCOTA)
@NoArgsConstructor
public class Mascota {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private Integer id;
    @ColumnInfo(name="nombre")
    private String nombre;
    @ColumnInfo(name="raza")
    private String raza;
    @ColumnInfo(name="fechaNacimiento")
    private String fechaNacimiento;
    @ColumnInfo(name="peso")
    private String peso;
    @ColumnInfo(name="imagen")
    private int imagen;
}
