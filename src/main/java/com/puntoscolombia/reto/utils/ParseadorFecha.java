package com.puntoscolombia.reto.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
public class ParseadorFecha {
    private static final DateTimeFormatter FORMATO_ENTRADA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Recibe una fecha en formato dd/MM/yyyy y retorna
     * un objeto con día, mes, año y nombre del mes en inglés
     */
    public static FechaCalendario parsear(String fechaTexto) {
        if (fechaTexto == null || fechaTexto.isBlank()) {
            throw new IllegalArgumentException("La fecha no puede ser nula o vacía");
        }

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaTexto.trim(), FORMATO_ENTRADA);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Formato de fecha inválido: '" + fechaTexto + "'. Se esperaba dd/MM/yyyy", e);
        }

        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonthValue();
        int anio = fecha.getYear();
        String nombreMesIngles = fecha.getMonth()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH); // "July"

        return new FechaCalendario(dia, mes, anio, nombreMesIngles);
    }
}
