package com.puntoscolombia.reto.stepdefinitions;

import com.puntoscolombia.reto.models.Pasajero;
import io.cucumber.java.DataTableType;

import java.util.Map;
public class Transformers {
    @DataTableType
    public Pasajero pasajeroEntryTransformer(Map<String, String> entry) {
        return new Pasajero(
                entry.get("nombre"),
                entry.get("email"),
                entry.get("numeroSeguridadSocial"),
                entry.get("telefono"),
                entry.get("codigoPromocional")
        );
    }
}
