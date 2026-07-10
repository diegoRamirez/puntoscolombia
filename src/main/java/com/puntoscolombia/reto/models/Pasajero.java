package com.puntoscolombia.reto.models;

public class Pasajero {
    private String nombre;
    private String email;
    private String numeroSeguridadSocial;
    private String telefono;
    //private String archivo;
    private String codigoPromocional;
    public Pasajero() {
    }

    public Pasajero(String nombre,
                         String email,
                         String numeroSeguridadSocial,
                         String telefono,
                         //String archivo,
                         String codigoPromocional) {

        this.nombre = nombre;
        this.email = email;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.telefono = telefono;
        //this.archivo = archivo;
        this.codigoPromocional = codigoPromocional;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    /*public String getArchivo() {
        return archivo;
    }*/
    public String getCodigoPromocional(){
        return codigoPromocional;
    }
}
