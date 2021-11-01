package com.kevin.walkyourpet.entities;




import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import com.kevin.walkyourpet.persistencia.Tabla;



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
}
