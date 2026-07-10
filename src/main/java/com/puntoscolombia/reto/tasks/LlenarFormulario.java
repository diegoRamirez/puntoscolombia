package com.puntoscolombia.reto.tasks;

import com.puntoscolombia.reto.models.Pasajero;
import com.puntoscolombia.reto.utils.UtilProperties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.puntoscolombia.reto.userinterfaces.PaginaCheckout.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormulario implements Task {
    private final Pasajero pasajero;
    private final String rutaArchivo = UtilProperties.getData("ruta.archivo");
    public LlenarFormulario(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public static Performable con(Pasajero pasajero) {
        return instrumented(LlenarFormulario.class, pasajero);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(pasajero.getNombre()).into(NOMBRE),
                Enter.theValue(pasajero.getEmail()).into(EMAIL),
                Enter.theValue(pasajero.getNumeroSeguridadSocial()).into(NUMERO_SEGURIDAD_SOCIAL),
                Enter.theValue(pasajero.getTelefono()).into(TELEFONO),
                CargarArchivo.con(rutaArchivo),
                Enter.theValue(pasajero.getCodigoPromocional()).into(CODIGO_PROMOCIONAL),
                Click.on(BTN_APPLY),
                Click.on(CHECK_TERMINOS_CONDICIONES),
                Click.on(BTN_PAY_NOW)
        );

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
