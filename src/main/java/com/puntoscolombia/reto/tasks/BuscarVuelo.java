package com.puntoscolombia.reto.tasks;

import com.puntoscolombia.reto.models.DatosViaje;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import static com.puntoscolombia.reto.userinterfaces.Buscador.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarVuelo implements Task {
    private final DatosViaje datos;

    public BuscarVuelo(DatosViaje datos) {
        this.datos = datos;
    }

    public static Performable con(DatosViaje datos) {
        return instrumented(BuscarVuelo.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(INPUT_FECHA_SALIDA),
                SeleccionarFecha.conValor(datos.getFechaSalida()),
                Click.on(INPUT_FECHA_LLEGADA),
                SeleccionarFecha.conValor(datos.getFechaLlegada()),
                Click.on(INPUT_ADULTOS),
                Click.on(CANTIDAD_ADULTOS(datos.getCantidadAdultos())),
                Click.on(INPUT_MENORES),
                Click.on(CANTIDAD_MENORES(datos.getCantidadMenores())),
                Click.on(BTN_SELECT_DESTINATION),
                Scroll.to(BTN_LOAD_MORE),
                Click.on(BTN_LOAD_MORE),
                Scroll.to(FILTRO)

        );


    }
}
