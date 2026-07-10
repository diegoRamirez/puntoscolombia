package com.puntoscolombia.reto.tasks;

import com.puntoscolombia.reto.utils.UtilProperties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Task {
    private final String url = UtilProperties.getData("url.reservas");

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("URL = " + url);
        actor.attemptsTo(Open.url(url));
    }

    public static OpenPage throughOfThe() {
        return instrumented(OpenPage.class);

    }
}
