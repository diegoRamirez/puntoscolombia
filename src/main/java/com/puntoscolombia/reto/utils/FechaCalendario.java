package com.puntoscolombia.reto.utils;

public class FechaCalendario {
    private final int dia;
    private final int mes;       // 1 a 12 (numérico, como viene del input)
    private final int anio;
    private final String nombreMesIngles; // útil para comparar con el título del calendario ("July")

    public FechaCalendario(int dia, int mes, int anio, String nombreMesIngles) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.nombreMesIngles = nombreMesIngles;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public String getNombreMesIngles() {
        return nombreMesIngles;
    }

    @Override
    public String toString() {
        return String.format("día=%d, mes=%d (%s), año=%d", dia, mes, nombreMesIngles, anio);
    }
}
