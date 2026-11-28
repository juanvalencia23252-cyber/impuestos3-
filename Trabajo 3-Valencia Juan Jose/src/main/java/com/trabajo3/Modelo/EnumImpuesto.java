package com.example.trabajo3.Modelo;

public enum EnumImpuesto {

    IVA("IVA"),
    RENTA("Impuesto de Renta"),
    ICA("ICA"),
    PREDIAL("Impuesto Predial"),
    CONSUMO("Impuesto al Consumo");

    private final String nombre;

    EnumImpuesto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
