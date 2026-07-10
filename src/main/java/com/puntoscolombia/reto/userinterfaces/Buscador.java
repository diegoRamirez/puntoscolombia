package com.puntoscolombia.reto.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Buscador {
    public static final Target INPUT_FECHA_SALIDA= Target.the("Input fecha salida")
            .locatedBy("(//div[@data-react-toolbox='input'])[1]//input");

    public static final Target INPUT_FECHA_LLEGADA = Target.the("Input fecha llegada")
            .locatedBy("(//div[@data-react-toolbox='input'])[2]//input");

    public static Target DIA(String day) {
        return Target.the("Day " + day)
                .locatedBy("//div[@data-react-toolbox='day']//span[text()='" + day + "']");
    }


    public static final Target INPUT_ADULTOS = Target.the("Input cantidad de adultos")
            .locatedBy("(//div[@data-react-toolbox='input'])[3]//input");

    public static final Target INPUT_MENORES = Target.the("Input cantidad de menores")
            .locatedBy("(//div[@data-react-toolbox='input'])[4]//input");

    public static final Target CANTIDAD_ADULTOS(int cantidadAdultos) {
        if (cantidadAdultos > 4) {
            throw new IllegalArgumentException(
                    "La cantidad de adultos no puede ser mayor a 4. Valor recibido: " + cantidadAdultos);
        }
        return Target.the("Cantidad Adultos")
            .locatedBy("(//div[@data-react-toolbox='dropdown'])//li["+(cantidadAdultos+1)+"]");
    }

    public static final Target CANTIDAD_MENORES(int cantidadMenores) {
        if (cantidadMenores > 4) {
            throw new IllegalArgumentException(
                    "La cantidad de adultos no puede ser mayor a 4. Valor recibido: " + cantidadMenores);
        }
        return Target.the("Cantidad Menores")
                .locatedBy("(//div[@data-react-toolbox='dropdown'])[2]//li["+(cantidadMenores+1)+"]");
    }

    public static final Target FILTRO = Target.the("Filtro precio")
            .locatedBy("//div//input[@value='1800']");

    public static final Target INPUT_FILTRO = Target.the("Input filtro precio")
            .locatedBy("(//div[@data-react-toolbox='input']//input[@type='text'])[4]");


    public static final Target BTN_SELECT_DESTINATION = Target.the("Select Destination")
            .located(By.xpath("//button[@class='theme__button___1iKuo CTAButton__button___2nXRo theme__raised___ONZv6 CTAButton__raised___1nGcA theme__primary___2NhN1 CTAButton__primary___WQCBB Hero__cta-button___9VskW']"));

    public static final Target BTN_LOAD_MORE = Target.the("Button Load more")
            .located(By.xpath("//button[@class='theme__button___1iKuo CTAButton__button___2nXRo theme__raised___ONZv6 CTAButton__raised___1nGcA theme__primary___2NhN1 CTAButton__primary___WQCBB Gallery__cta-button___3kPlJ']"));

    private static final String SLIDER_BASE =
            "//div[contains(@class,'price-filter-slider')]";

    public static final Target CONTAINER =
            Target.the("contenedor del slider de precio")
                    .locatedBy(SLIDER_BASE + "//div[contains(@class,'container')]");

    public static final Target KNOB =
            Target.the("knob del slider de precio")
                    .locatedBy(SLIDER_BASE + "//div[contains(@class,'knob') and not(contains(@class,'innerknob'))]");

    public static final Target PROGRESS_BAR =
            Target.the("barra de progreso del slider de precio")
                    .locatedBy(SLIDER_BASE + "//div[@data-react-toolbox='progress-bar']");

}
