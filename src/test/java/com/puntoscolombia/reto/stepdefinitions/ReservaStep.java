package com.puntoscolombia.reto.stepdefinitions;

import com.puntoscolombia.reto.models.DatosViaje;
import com.puntoscolombia.reto.tasks.BuscarVuelo;
import com.puntoscolombia.reto.tasks.EstablecerPrecioMaximo;
import com.puntoscolombia.reto.tasks.OpenPage;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservaStep {


    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }
    @Managed
    WebDriver hisBrowser;
    @Dado("que el usuario se encuentra en la página de búsqueda de vuelos")
    public void queElUsuarioSeEncuentraEnLaPaginaDeBusquedaDeVuelos() {

        theActorCalled("actor").whoCan(BrowseTheWeb.with(hisBrowser));
        theActorInTheSpotlight().wasAbleTo(OpenPage.throughOfThe());

    }

    @Cuando("realiza una búsqueda con los siguientes datos")
    public void realizaUnaBusquedaConLosSiguientesDatos(List<DatosViaje> datosViaje) {

        DatosViaje datos = datosViaje.get(0);

        theActorInTheSpotlight().attemptsTo(
                BuscarVuelo.con(datos)
        );
    }


    /*@Y("elige el destino que le interesa con un precio máximo de {int}")
    public void eligeElDestinoQueLeInteresaConUnPrecioMaximoDe(int precioMaximo) {
        theActorInTheSpotlight().attemptsTo(
                EstablecerPrecioMaximo.con(precioMaximo)
        );}*/

    @Entonces("deberia ver su reserva finalizada exitosamente")
    public void deberiaVerSuReservaFinalizadaExitosamente() {
    }


    @Y("elige el destino que le interesa {String} con un precio máximo de {int}")
    public void eligeElDestinoQueLeInteresaDestinoConUnPrecioMáximoDePrecioMaximo(String destino,int precioMaximo) {
        theActorInTheSpotlight().attemptsTo(
                EstablecerPrecioMaximo.con(precioMaximo)
        );
    }
}
