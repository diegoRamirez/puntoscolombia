package com.puntoscolombia.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Home {
    public static final Target FECHA_SALIDA = Target.the("Fecha salida")
            .locatedBy("//input[@id='referral-email']");
}
