package com.puntoscolombia.reto.tasks;




import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static com.puntoscolombia.reto.userinterfaces.Buscador.*;


public class EstablecerPrecioMaximo implements Task{

    private final int precioMaximo;

    public EstablecerPrecioMaximo(int precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    public static EstablecerPrecioMaximo con(int precioMaximo) {
        return Instrumented.instanceOf(EstablecerPrecioMaximo.class).withProperties(precioMaximo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebElement container = BrowseTheWeb.as(actor).find(CONTAINER);
        WebElement knob = BrowseTheWeb.as(actor).find(KNOB);
        WebElement progressBar = BrowseTheWeb.as(actor).find(PROGRESS_BAR);

        int min = Integer.parseInt(progressBar.getAttribute("aria-valuemin"));
        int max = Integer.parseInt(progressBar.getAttribute("aria-valuemax"));
        int valorActual = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));

        if (precioMaximo < min || precioMaximo > max) {
            throw new IllegalArgumentException(
                    "El precio máximo (" + precioMaximo + ") está fuera del rango del filtro: [" + min + " - " + max + "]");
        }

        // 1. Movimiento grueso: acercarse con el cálculo de offset en píxeles
        int anchoContenedor = container.getSize().getWidth();
        double pixelesPorUnidad = (double) anchoContenedor / (max - min);
        int deltaValor = precioMaximo - valorActual;
        int offsetX = (int) Math.round(deltaValor * pixelesPorUnidad);

        new Actions(driver)
                .clickAndHold(knob)
                .moveByOffset(offsetX, 0)
                .release()
                .perform();

        // 2. Ajuste fino: garantizar que quede <= precioMaximo (nunca por encima)
        ajustarHaciaAbajoSiExcede(driver, progressBar, knob);
    }

    /**
     * Garantiza que el valor final del slider sea MENOR O IGUAL al precio máximo
     * solicitado. Un filtro de "precio máximo" se cumple igual con un valor
     * ligeramente menor; lo que NO puede pasar es que quede por encima.
     */
    private void ajustarHaciaAbajoSiExcede(WebDriver driver, WebElement progressBar, WebElement knob) {
        int intentos = 0;
        int maxIntentos = 30;

        int valorActual = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));

        while (valorActual > precioMaximo && intentos < maxIntentos) {
            new Actions(driver)
                    .clickAndHold(knob)
                    .moveByOffset(-1, 0)
                    .release()
                    .perform();

            valorActual = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));
            intentos++;
        }

        if (valorActual > precioMaximo) {
            throw new IllegalStateException(
                    "El slider quedó en " + valorActual + ", que supera el precio máximo permitido (" + precioMaximo + ")");
        }

        // Log informativo para el reporte, útil si quedó por debajo del valor exacto
        if (valorActual < precioMaximo) {
            System.out.println(">>> Slider quedó en " + valorActual +
                    " (precio máximo solicitado: " + precioMaximo + "). Diferencia por límite de granularidad del componente.");
        }
    }

}
