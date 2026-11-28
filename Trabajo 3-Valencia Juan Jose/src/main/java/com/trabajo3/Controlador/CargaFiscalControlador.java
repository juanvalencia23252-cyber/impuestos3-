package com.example.trabajo3.Controlador;

import com.example.trabajo3.Modelo.CargaFiscal;
import com.example.trabajo3.Modelo.EnumImpuesto;
import com.example.trabajo3.Modelo.Impuesto;
import com.example.trabajo3.Repositories.CargaFiscalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class CargaFiscalControlador {

    private final CargaFiscalRepository repositorio;

    public CargaFiscalControlador(CargaFiscalRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/cargafiscal")
    public String mostrar(Model model) {
        Stack<Impuesto> pila = repositorio.crearNuevosImpuestos();
        CargaFiscal cargaFiscal = repositorio.crearCargaFiscal(pila);

        // Punto 2: ListIterator sobre el Stack y Iterator sobre el Deque
        List<String> mensajesPila = new ArrayList<>();
        ListIterator<Impuesto> listIterator = pila.listIterator();
        while (listIterator.hasNext()) {
            Impuesto imp = listIterator.next();
            mensajesPila.add(describir(imp));
        }

        List<String> mensajesDeque = new ArrayList<>();
        Iterator<Impuesto> iterator = cargaFiscal.getImpuestos().iterator();
        while (iterator.hasNext()) {
            Impuesto imp = iterator.next();
            mensajesDeque.add(describir(imp));
        }

        // Punto 3: Conversión de Stack a Deque y programación funcional sobre el Deque
        Deque<Impuesto> dequeImpuestos = new ArrayDeque<>(pila);

        List<String> filtrados = dequeImpuestos.stream()
                .filter(imp -> imp.getTipoImpuesto() == EnumImpuesto.IVA)
                .map(this::describir)
                .collect(Collectors.toList());

        // Punto 4: Function<Impuesto, Integer> que suma el Stack conteo
        Function<Impuesto, Integer> sumarConteo = impuesto -> {
            int suma = 0;
            for (int numero : impuesto.getConteo()) {
                suma += numero;
            }
            return suma;
        };

        List<String> sumas = new ArrayList<>();
        for (Impuesto imp : pila) {
            sumas.add("Impuesto: " + imp.getConcepto()
                    + " - Suma del conteo: " + sumarConteo.apply(imp));
        }

        // Punto 5: Llamado al método verTotales desde un objeto Impuesto
        Impuesto impuestoElegido = pila.get(0);
        String totales = impuestoElegido.verTotales(sumarConteo);

        model.addAttribute("cargaFiscal", cargaFiscal);
        model.addAttribute("mensajesPila", mensajesPila);
        model.addAttribute("mensajesDeque", mensajesDeque);
        model.addAttribute("filtrados", filtrados);
        model.addAttribute("sumas", sumas);
        model.addAttribute("totales", totales);

        return "cargafiscal";
    }

    private String describir(Impuesto imp) {
        return "Concepto: " + imp.getConcepto()
                + " | Contribuyente: " + imp.getContribuyente()
                + " | Tarifa: " + imp.getTarifaPorcentaje() + "%"
                + " | Tipo de Impuesto: " + imp.getTipoImpuesto().getNombre()
                + " | Categoría: " + imp.getCategoria().getNombre()
                + " | Conteo: " + imp.getConteo();
    }
}
