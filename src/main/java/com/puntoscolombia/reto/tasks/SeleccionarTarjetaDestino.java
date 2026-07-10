package com.puntoscolombia.reto.tasks;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static com.puntoscolombia.reto.userinterfaces.Buscador.TARJETA_DESTINO;

public class SeleccionarTarjetaDestino implements Task{
    private final String destino;

    public SeleccionarTarjetaDestino(String destino) {
        this.destino = destino;
    }

    public static SeleccionarTarjetaDestino con(String destino) {
        return Instrumented.instanceOf(SeleccionarTarjetaDestino.class).withProperties(destino);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade boton = BrowseTheWeb.as(actor)
                .find(TARJETA_DESTINO(destino));

        String textoBoton = boton.getText().trim();

        if (!textoBoton.equalsIgnoreCase("Book")) {
            throw new IllegalStateException(
                    "El botón del destino '" + destino + "' no está en estado 'Book'. " +
                            "Estado actual: '" + textoBoton + "'. Puede que ya haya sido reservado previamente.");
        }

        actor.attemptsTo(
                Click.on(TARJETA_DESTINO(destino))
        );

    }
}
