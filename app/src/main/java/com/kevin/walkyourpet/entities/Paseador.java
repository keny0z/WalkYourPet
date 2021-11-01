package com.kevin.walkyourpet.entities;

public class Paseador {
    private int imagen;
    private String nombre;
    private int edad;
    private String distancia;

    public Paseador(int imagen, String nombre, int edad, String distancia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.distancia = distancia;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDistancia() {
        return distancia;
    }
}
