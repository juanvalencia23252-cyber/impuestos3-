package com.example.trabajo3.Modelo;

public enum Categoria {

    NACIONAL("Nacional"),
    DEPARTAMENTAL("Departamental"),
    MUNICIPAL("Municipal");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
