package com.puntoscolombia.reto.tasks;



import com.puntoscolombia.reto.questions.MesYAnioMostrado;
import com.puntoscolombia.reto.userinterfaces.Calendario;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarHastaMesYAnio implements Task {

    private final int mesObjetivo;
    private final int anioObjetivo;
    private final String nombreMesInglesObjetivo;

    public NavegarHastaMesYAnio(int mesObjetivo, int anioObjetivo, String nombreMesInglesObjetivo) {
        this.mesObjetivo = mesObjetivo;
        this.anioObjetivo = anioObjetivo;
        this.nombreMesInglesObjetivo = nombreMesInglesObjetivo;
    }

    public static NavegarHastaMesYAnio hasta(int mes, int anio, String nombreMesIngles) {
        return Instrumented.instanceOf(NavegarHastaMesYAnio.class)
                .withProperties(mes, anio, nombreMesIngles);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(Calendario.DIALOGO_ACTIVO_XPATH, isVisible())
        );
        YearMonth mesDeseado = YearMonth.of(anioObjetivo, mesObjetivo);

        String textoMostrado = MesYAnioMostrado.delCalendario().answeredBy(actor); // ej: "July 2026"
        YearMonth mesMostrado = parsearMesYAnioMostrado(textoMostrado);

        long diferenciaMeses = mesDeseado.getMonthValue() - mesMostrado.getMonthValue()
                + (mesDeseado.getYear() - mesMostrado.getYear()) * 12L;

        if (diferenciaMeses == 0) {
            return; // ya estamos en el mes/año correcto
        }

        var boton = diferenciaMeses > 0
                ? Calendario.BOTON_MES_SIGUIENTE
                : Calendario.BOTON_MES_ANTERIOR;

        for (int i = 0; i < Math.abs(diferenciaMeses); i++) {
            actor.attemptsTo(
                    Click.on(boton),
                    WaitUntil.the(Calendario.TITULO_MES_ANIO, isVisible())
            );
        }
    }

    private YearMonth parsearMesYAnioMostrado(String textoMostrado) {
        return YearMonth.parse(
                textoMostrado.trim(),
                DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH)
        );
    }
}
