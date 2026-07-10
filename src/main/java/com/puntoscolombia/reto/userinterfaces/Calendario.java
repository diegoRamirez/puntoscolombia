package com.puntoscolombia.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Calendario {
    public static final String DIALOGO_ACTIVO_XPATH =
            "//div[@data-react-toolbox='dialog' and contains(@class,'active')]";

    public static final Target TITULO_MES_ANIO =
            Target.the("título mes/año visible")
                    .locatedBy(DIALOGO_ACTIVO_XPATH + "//div[@data-react-toolbox='month']//span[contains(@class,'title')]");

    public static final Target BOTON_MES_SIGUIENTE =
            Target.the("botón mes siguiente")
                    .locatedBy(DIALOGO_ACTIVO_XPATH + "//button[@id='right']");

    public static final Target BOTON_MES_ANTERIOR =
            Target.the("botón mes anterior")
                    .locatedBy(DIALOGO_ACTIVO_XPATH + "//button[@id='left']");

    public static final Target BTN_OK = Target.the("Boton OK")
            .locatedBy("//nav[@role='navigation']//button[2]");

    public static Target diaDisponible(int dia) {
        return Target.the("día " + dia + " habilitado")
                .locatedBy(String.format(
                        DIALOGO_ACTIVO_XPATH +
                                "//div[@data-react-toolbox='day' and not(contains(@class,'disabled'))]" +
                                "//span[normalize-space(text())='%d']/parent::div", dia));
    }

}
