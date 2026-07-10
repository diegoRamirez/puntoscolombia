package com.puntoscolombia.reto.questions;

import com.puntoscolombia.reto.userinterfaces.Calendario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MesYAnioMostrado implements Question<String> {

    public static MesYAnioMostrado delCalendario() {
        return new MesYAnioMostrado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(Calendario.TITULO_MES_ANIO).answeredBy(actor);
    }
}