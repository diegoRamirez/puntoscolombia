package com.puntoscolombia.reto.tasks;

import com.puntoscolombia.reto.questions.MesYAnioMostrado;
import com.puntoscolombia.reto.userinterfaces.Calendario;
import com.puntoscolombia.reto.utils.FechaCalendario;
import com.puntoscolombia.reto.utils.ParseadorFecha;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.puntoscolombia.reto.userinterfaces.Calendario.BTN_OK;

public class SeleccionarFecha implements Task {
    private final FechaCalendario fecha;

    public SeleccionarFecha(FechaCalendario fecha) {
        this.fecha = fecha;
    }

    public static SeleccionarFecha conValor(String fechaDDMMYYYY) {
        FechaCalendario fechaParseada = ParseadorFecha.parsear(fechaDDMMYYYY);
        return Instrumented.instanceOf(SeleccionarFecha.class).withProperties(fechaParseada);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavegarHastaMesYAnio.hasta(fecha.getMes(), fecha.getAnio(), fecha.getNombreMesIngles()),
                Click.on(Calendario.diaDisponible(fecha.getDia())),
                Click.on(BTN_OK)
        );
    }
}
