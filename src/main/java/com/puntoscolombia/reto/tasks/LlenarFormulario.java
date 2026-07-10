package com.puntoscolombia.reto.tasks;

import com.puntoscolombia.reto.models.DatosViaje;
import com.puntoscolombia.reto.models.Pasajero;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.puntoscolombia.reto.userinterfaces.Buscador.*;
import static com.puntoscolombia.reto.userinterfaces.Buscador.BTN_LOAD_MORE;
import static com.puntoscolombia.reto.userinterfaces.Buscador.BTN_SELECT_DESTINATION;
import static com.puntoscolombia.reto.userinterfaces.Buscador.CANTIDAD_ADULTOS;
import static com.puntoscolombia.reto.userinterfaces.Buscador.CANTIDAD_MENORES;
import static com.puntoscolombia.reto.userinterfaces.Buscador.FILTRO;
import static com.puntoscolombia.reto.userinterfaces.Buscador.INPUT_MENORES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormulario implements Task {
    private final Pasajero pasajero;
    public LlenarFormulario(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public static Performable con(Pasajero pasajero) {
        return instrumented(LlenarFormulario.class, pasajero);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(


        );


    }
}
