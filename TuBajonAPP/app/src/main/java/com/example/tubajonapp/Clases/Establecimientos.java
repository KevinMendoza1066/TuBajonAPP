package com.example.tubajonapp.Clases;

public class Establecimientos {

    private String nombre;
    private String Direccion;
    private String Descripcion;
    public Establecimientos(String nombre, String Direccion,String Descripcion) {
        this.nombre=nombre;
        this.Direccion=Direccion;
        this.Descripcion=Descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return Direccion;
    }
    public String getDescripcion() {
        return Descripcion;
    }
}
