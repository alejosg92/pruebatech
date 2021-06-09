package com.avianca.certificacion.prueba.stepdefinition;

import com.avianca.certificacion.prueba.models.SearchFlightData;
import com.avianca.certificacion.prueba.tasks.SearchFlight;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

import java.util.List;

import static com.avianca.certificacion.prueba.drivers.ChromeDriver.chrome;
import static com.avianca.certificacion.prueba.tasks.SeeTripSummary.seeTripSummary;
import static com.avianca.certificacion.prueba.tasks.SelectSecondFlight.selectSecondFlight;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SearchFlightStep {

    @Before
    public void setUp(){
        setTheStage(new Cast());
        theActorCalled("Usuario");
    }

    @Given("^User visits Home of Avianca Page$")
    public void userVisitsHomeOfAviancaPage() {
        theActorInTheSpotlight().can(BrowseTheWeb.with(chrome().withURL("https://www.avianca.com/")));
    }

    @When("^Search a flight$")
    public void searchAFlight(List<SearchFlightData> searchFlightDataList) {
        SearchFlightData.EmptyList();
        SearchFlightData.SaveSearchFlightData(searchFlightDataList.get(0));
        theActorInTheSpotlight().attemptsTo(SearchFlight.withCityFrom(SearchFlightData.readData(0).getFrom()).
                andCityTo(SearchFlightData.readData(0).getTo()).
                andDateFrom(SearchFlightData.readData(0).getDateFrom()).
                andDateTo(SearchFlightData.readData(0).getDateTo()).
                andNumberAdults(SearchFlightData.readData(0).getNumberAdults()).
                andNumberChildren(SearchFlightData.readData(0).getNumberChildren()).
                andNumberInfants(SearchFlightData.readData(0).getNumberInfants()));
    }

    @And("^Select the second option of flights$")
    public void selectTheSecondOptionOfFlights() {
        theActorInTheSpotlight().attemptsTo(selectSecondFlight());
    }

    @Then("^See the trip Summary$")
    public void seeTheTripSummary() {
        theActorInTheSpotlight().attemptsTo(seeTripSummary());
    }
}
