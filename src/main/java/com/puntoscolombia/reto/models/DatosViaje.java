package com.puntoscolombia.reto.models;

import java.math.BigDecimal;

public class DatosViaje {
    private String fechaSalida;
    private String fechaLlegada;
    private int cantidadAdultos;
    private int cantidadMenores;
    private String destino;
    private BigDecimal precioMaximo;

    public DatosViaje() {
    }

    public DatosViaje(String fechaSalida,
                      String fechaLlegada,
                      int cantidadAdultos,
                      int cantidadMenores,
                      String destino,
                      BigDecimal precioMaximo) {

        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadMenores = cantidadMenores;
        this.destino = destino;
        this.precioMaximo = precioMaximo;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public int getCantidadMenores() {
        return cantidadMenores;
    }

    public String getDestino() {
        return destino;
    }

    public BigDecimal getPrecioMaximo() {
        return precioMaximo;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public void setCantidadMenores(int cantidadMenores) {
        this.cantidadMenores = cantidadMenores;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPrecioMaximo(BigDecimal precioMaximo) {
        this.precioMaximo = precioMaximo;
    }
}
