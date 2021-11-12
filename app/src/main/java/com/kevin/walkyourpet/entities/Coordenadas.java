package com.kevin.walkyourpet.entities;

import androidx.room.ColumnInfo;

import lombok.Data;
import lombok.NoArgsConstructor;


public class Coordenadas {
    @ColumnInfo(name="latitud")
    private Double latitud;
    @ColumnInfo(name="longitud")
    private Double longitud;

    public Double getLatitud() {
        if (latitud==null){
            setLatitud(6.1494576);
        }
        return latitud;
    }

    public Double getLongitud() {
        if(longitud==null){
            setLongitud(-75.3796319);
        }
        return longitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
