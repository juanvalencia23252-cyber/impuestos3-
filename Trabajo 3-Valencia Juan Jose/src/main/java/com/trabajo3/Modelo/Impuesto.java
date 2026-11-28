package com.example.trabajo3.Modelo;

import java.util.Stack;
import java.util.function.Function;

public class Impuesto {
    private String concepto;
    private String contribuyente;
    private double tarifaPorcentaje;
    private EnumImpuesto tipoImpuesto;
    private Categoria categoria;
    private Stack<Integer> conteo;

    public Impuesto() {
        this.conteo = new Stack<>();
    }

    public Impuesto(String concepto, String contribuyente, double tarifaPorcentaje,
                    EnumImpuesto tipoImpuesto, Categoria categoria) {
        this.concepto = concepto;
        this.contribuyente = contribuyente;
        this.tarifaPorcentaje = tarifaPorcentaje;
        this.tipoImpuesto = tipoImpuesto;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }

    public void agregarConteo(int valor) {
        conteo.push(valor);
    }

    public String verTotales(Function<Impuesto, Integer> funcion) {
        int total = funcion.apply(this);
        return "El impuesto \"" + this.concepto + "\" tiene un total de " + total + " en su conteo de liquidaciones";
    }

    public void setConcepto(String concepto) { this.concepto = concepto; }
    public void setContribuyente(String contribuyente) { this.contribuyente = contribuyente; }
    public void setTarifaPorcentaje(double tarifaPorcentaje) { this.tarifaPorcentaje = tarifaPorcentaje; }
    public void setTipoImpuesto(EnumImpuesto tipoImpuesto) { this.tipoImpuesto = tipoImpuesto; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setConteo(Stack<Integer> conteo) { this.conteo = conteo; }

    public String getConcepto() { return concepto; }
    public String getContribuyente() { return contribuyente; }
    public double getTarifaPorcentaje() { return tarifaPorcentaje; }
    public EnumImpuesto getTipoImpuesto() { return tipoImpuesto; }
    public Categoria getCategoria() { return categoria; }
    public Stack<Integer> getConteo() { return conteo; }
}
