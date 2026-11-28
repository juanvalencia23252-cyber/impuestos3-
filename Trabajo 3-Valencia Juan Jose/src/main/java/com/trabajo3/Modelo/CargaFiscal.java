package com.example.trabajo3.Modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class CargaFiscal {
    private String responsable;
    private String entidad;
    private EnumImpuesto tipoImpuesto;
    private Categoria categoria;
    private Deque<Impuesto> impuestos;

    public CargaFiscal() {
        this.impuestos = new ArrayDeque<>();
    }

    public CargaFiscal(String responsable, String entidad,
                       EnumImpuesto tipoImpuesto, Categoria categoria) {
        this.responsable = responsable;
        this.entidad = entidad;
        this.tipoImpuesto = tipoImpuesto;
        this.categoria = categoria;
        this.impuestos = new ArrayDeque<>();
    }

    public void agregarImpuesto(Impuesto impuesto) {
        impuestos.add(impuesto);
    }

    public void setResponsable(String responsable) { this.responsable = responsable; }
    public void setEntidad(String entidad) { this.entidad = entidad; }
    public void setTipoImpuesto(EnumImpuesto tipoImpuesto) { this.tipoImpuesto = tipoImpuesto; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setImpuestos(Deque<Impuesto> impuestos) { this.impuestos = impuestos; }

    public String getResponsable() { return responsable; }
    public String getEntidad() { return entidad; }
    public EnumImpuesto getTipoImpuesto() { return tipoImpuesto; }
    public Categoria getCategoria() { return categoria; }
    public Deque<Impuesto> getImpuestos() { return impuestos; }
}
