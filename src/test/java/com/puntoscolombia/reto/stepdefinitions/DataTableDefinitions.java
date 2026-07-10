package com.puntoscolombia.reto.stepdefinitions;

import com.puntoscolombia.reto.models.DatosViaje;
import io.cucumber.java.DataTableType;

import java.math.BigDecimal;
import java.util.Map;
public class DataTableDefinitions {
    @DataTableType
    public DatosViaje datosViaje(Map<String, String> row) {

        DatosViaje datos = new DatosViaje();

        datos.setFechaSalida(row.get("fechaSalida"));
        datos.setFechaLlegada(row.get("fechaLlegada"));
        datos.setCantidadAdultos(Integer.parseInt(row.get("cantidadAdultos")));
        datos.setCantidadMenores(Integer.parseInt(row.get("cantidadMenores")));

        if (row.containsKey("destino")) {
            datos.setDestino(row.get("destino"));
        }

        if (row.containsKey("precioMaximo")) {
            datos.setPrecioMaximo(new BigDecimal(row.get("precioMaximo")));
        }

        return datos;
    }
}
