package com.kevin.walkyourpet.sesion;

import com.kevin.walkyourpet.R;
import com.kevin.walkyourpet.entities.Paseador;

import java.util.ArrayList;

public class Paseadores {
    private static ArrayList<Paseador> paseadores = new ArrayList<>();
    Paseador paseadorUco = new Paseador();


    private Paseadores(){

    }
    public static ArrayList<Paseador> obtenerPaseadores(){
        if (paseadores.size()==0){
            inicializarPaseadores();
        }
        return paseadores;
    }
    private static void inicializarPaseadores(){
        Paseador paseadorUco = new Paseador();
        paseadorUco.setUsuario("Juan");
        paseadorUco.setNombre("Juan");
        paseadorUco.setApellido("Osorio");
        paseadorUco.setClave("123");
        paseadorUco.setFechaNacimiento("17/07/2001");
        paseadorUco.setCelular("3014470368");
        paseadorUco.setLatitud(6.1505397);
        paseadorUco.setLongitud(-75.3660258);
        paseadorUco.setImagen(R.drawable.paseador3);

        Paseador paseadorSanNicolas = new Paseador();
        paseadorSanNicolas.setUsuario("Laura");
        paseadorSanNicolas.setNombre("Laura");
        paseadorSanNicolas.setApellido("Otalvaro");
        paseadorSanNicolas.setClave("123");
        paseadorSanNicolas.setFechaNacimiento("17/07/2001");
        paseadorSanNicolas.setCelular("3007613589");
        paseadorSanNicolas.setLatitud(6.1477279);
        paseadorSanNicolas.setLongitud(-75.3778181);
        paseadorSanNicolas.setImagen(R.drawable.paseador);

        Paseador paseadorAeropuerto = new Paseador();
        paseadorAeropuerto.setUsuario("Carlos");
        paseadorAeropuerto.setNombre("Carlos");
        paseadorAeropuerto.setApellido("Echeverri");
        paseadorAeropuerto.setClave("123");
        paseadorAeropuerto.setFechaNacimiento("17/07/2001");
        paseadorAeropuerto.setCelular("3016840358");
        paseadorAeropuerto.setLatitud(6.1702782);
        paseadorAeropuerto.setLongitud(-75.4257591);
        paseadorAeropuerto.setImagen(R.drawable.paseador2);

/*
        Paseador paseadorNasa = new Paseador();
        paseadorAeropuerto.setUsuario("David");
        paseadorAeropuerto.setNombre("David");
        paseadorAeropuerto.setApellido("Gomez");
        paseadorAeropuerto.setClave("123");
        paseadorAeropuerto.setFechaNacimiento("17/07/2001");
        paseadorAeropuerto.setCelular("3005256544");
        paseadorAeropuerto.setLatitud(37.4244255);
        paseadorAeropuerto.setLongitud(-122.0676703);
        paseadorAeropuerto.setImagen(R.drawable.paseador2);

 */




        paseadores.add(paseadorUco);
        paseadores.add(paseadorSanNicolas);
        paseadores.add(paseadorAeropuerto);
        //paseadores.add(paseadorNasa);

    }
}
