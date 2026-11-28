package com.example.trabajo3.Repositories;

import com.example.trabajo3.Modelo.CargaFiscal;
import com.example.trabajo3.Modelo.Categoria;
import com.example.trabajo3.Modelo.EnumImpuesto;
import com.example.trabajo3.Modelo.Impuesto;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public class CargaFiscalRepository {

    public Stack<Impuesto> crearNuevosImpuestos() {
        Stack<Impuesto> nuevosImpuestos = new Stack<>();

        Impuesto impuesto1 = new Impuesto("Declaración IVA Bimestral", "Mateo Restrepo", 19.0, EnumImpuesto.IVA, Categoria.NACIONAL);
        impuesto1.agregarConteo(120);
        impuesto1.agregarConteo(85);
        impuesto1.agregarConteo(95);

        Impuesto impuesto2 = new Impuesto("Retención en la Fuente", "Valentina Echeverri", 3.5, EnumImpuesto.RENTA, Categoria.NACIONAL);
        impuesto2.agregarConteo(60);
        impuesto2.agregarConteo(40);

        Impuesto impuesto3 = new Impuesto("Industria y Comercio Medellín", "Daniel Osorio", 0.7, EnumImpuesto.ICA, Categoria.MUNICIPAL);
        impuesto3.agregarConteo(45);
        impuesto3.agregarConteo(30);

        Impuesto impuesto4 = new Impuesto("Predial Unificado Urbano", "Luisa Fernanda Cano", 1.2, EnumImpuesto.PREDIAL, Categoria.MUNICIPAL);

        Impuesto impuesto5 = new Impuesto("Impuesto Nacional al Consumo", "Tomás Montoya", 8.0, EnumImpuesto.CONSUMO, Categoria.NACIONAL);
        impuesto5.agregarConteo(25);
        impuesto5.agregarConteo(50);
        impuesto5.agregarConteo(15);

        nuevosImpuestos.push(impuesto1);
        nuevosImpuestos.push(impuesto2);
        nuevosImpuestos.push(impuesto3);
        nuevosImpuestos.push(impuesto4);
        nuevosImpuestos.push(impuesto5);

        return nuevosImpuestos;
    }

    public CargaFiscal crearCargaFiscal(Stack<Impuesto> nuevosImpuestos) {
        CargaFiscal cargaFiscal = new CargaFiscal(
                "Alejandro Quintero",
                "Dirección de Impuestos - Medellín",
                EnumImpuesto.IVA,
                Categoria.NACIONAL
        );

        for (Impuesto imp : nuevosImpuestos) {
            cargaFiscal.agregarImpuesto(imp);
        }
        return cargaFiscal;
    }
}
