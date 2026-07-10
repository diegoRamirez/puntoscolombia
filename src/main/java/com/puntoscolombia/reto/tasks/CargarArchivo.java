package com.puntoscolombia.reto.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.pages.WebElementFacade;

import java.io.File;

import static com.puntoscolombia.reto.userinterfaces.PaginaCheckout.CARGA_ARCHIVO;

public class CargarArchivo implements Task{
    private final String rutaArchivo;

    public CargarArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static CargarArchivo con(String rutaArchivo) {
        return Instrumented.instanceOf(CargarArchivo.class).withProperties(rutaArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            throw new IllegalArgumentException("El archivo no existe en la ruta: " + archivo.getAbsolutePath());
        }

        WebElementFacade input = BrowseTheWeb.as(actor).find(CARGA_ARCHIVO);
        input.sendKeys(archivo.getAbsolutePath());
    }
}
