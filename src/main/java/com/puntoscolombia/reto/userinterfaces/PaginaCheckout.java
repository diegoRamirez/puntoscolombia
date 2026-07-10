package com.puntoscolombia.reto.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaCheckout {

    public static final Target NOMBRE = Target.the("Enter name")
            .located(By.xpath("//div[@data-react-toolbox='input' and contains(., 'Name')]//input"));

    public static final Target EMAIL = Target.the("Enter email")
            .located(By.xpath("//div[@data-react-toolbox='input' and contains(., 'Email')]//input"));

    public static final Target NUMERO_SEGURIDAD_SOCIAL = Target.the("Enter social security number")
            .located(By.xpath("//div[@data-react-toolbox='input' and contains(., 'Social')]//input"));

    public static final Target TELEFONO = Target.the("Enter Phone")
            .located(By.xpath("//div[@data-react-toolbox='input' and contains(., 'Phone')]//input"));

    public static final Target CARGA_ARCHIVO = Target.the("Input for uploading a file")
            .located(By.xpath("//input[@type='file']"));

    public static final Target CODIGO_PROMOCIONAL = Target.the("Codigo promocional")
            .located(By.name("promo"));

    public static final Target CHECK_TERMINOS_CONDICIONES = Target.the("Check terminos y condiciones")
            .located(By.xpath("//div[@class='theme__check___2B20W']"));

    public static final Target BTN_APPLY = Target.the("Botón Apply")
            .located(By.xpath("//div[contains(@class, 'OrderSummary')]//button[@data-react-toolbox='button' and contains(., 'Apply')]"));

    public static final Target BTN_PAY_NOW = Target.the("Botón Pay Now")
            .located(By.xpath("//button[@data-react-toolbox='button' and normalize-space(text())='Pay now']"));


    /**
     * ADVERTENCIA: Este Target fue construido especulativamente, sin poder
     * verificarlo contra el DOM real, porque el mensaje "Destination Booked"
     * nunca llegó a renderizarse durante la ejecución en demo.testim.io.
     * Ajustar tan pronto se disponga de una versión funcional del flujo de pago.
     */
    public static final Target MENSAJE_DESTINATION_BOOKED =
            Target.the("mensaje de confirmación 'Destination Booked'")
                    .locatedBy("//*[contains(normalize-space(text()), 'Destination Booked')]");


}
