package com.puntoscolombia.reto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    private DatosViaje viaje;
    private Pasajero pasajero;
    private String promotionalCode;

}
