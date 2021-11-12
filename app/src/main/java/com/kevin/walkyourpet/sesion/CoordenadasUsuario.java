package com.kevin.walkyourpet.sesion;

import com.kevin.walkyourpet.entities.Coordenadas;
import com.kevin.walkyourpet.entities.Usuario;

public class CoordenadasUsuario {
    private static Coordenadas instancia = new Coordenadas();
    private CoordenadasUsuario() {

    }
    public static Coordenadas obtenerInstancia(){
        return instancia;
    }


}
