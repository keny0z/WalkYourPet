package com.kevin.walkyourpet.sesion;

import com.kevin.walkyourpet.entities.Usuario;

public class SesionUsuario {
    private static Usuario instancia = new Usuario();
    private SesionUsuario(){

    }
    public static Usuario obtenerInstancia(){
        return instancia;
    }
    public static void cargarUsuario(Usuario usuario){
        instancia.setId(usuario.getId());
        instancia.setUsuario(usuario.getUsuario());
        instancia.setNombre(usuario.getNombre());
        instancia.setApellido(usuario.getApellido());
        instancia.setClave(usuario.getClave());
        instancia.setFechaNacimiento(usuario.getFechaNacimiento());
        instancia.setCelular(usuario.getCelular());
    }
    public static void limpiarUsuario(){
        instancia.setId(0);
        instancia.setUsuario("");
        instancia.setNombre("");
        instancia.setApellido("");
        instancia.setClave("");
        instancia.setFechaNacimiento("");
        instancia.setCelular("");
    }
}
