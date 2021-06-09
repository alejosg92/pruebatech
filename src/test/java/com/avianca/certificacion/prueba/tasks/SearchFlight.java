package com.avianca.certificacion.prueba.tasks;


import com.avianca.certificacion.prueba.interactions.SelectTravelDateFrom;
import com.avianca.certificacion.prueba.interactions.SelectTravelDateTo;
import cucumber.api.java.eo.Se;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.fluentlenium.core.search.Search;

import static com.avianca.certificacion.prueba.interactions.SelectPassengers.*;
import static com.avianca.certificacion.prueba.pages.HomePage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SearchFlight implements Task {

    private String from, to, dateFrom, dateTo, numberAdults, numberChildren, numberInfants;

    public SearchFlight(String from){
        this.from = from;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.should(eventually(seeThat(the(INDESDE), isEnabled())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(BTNCOOKIES));
        takeScreenshot();
        actor.attemptsTo(Scroll.to(BTNRESERVAVUELO));
        actor.attemptsTo(Enter.theValue(from).into(INDESDE));
        actor.should(eventually(seeThat(the(LISTDESDE), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(LISTDESDE));
        actor.attemptsTo(Enter.theValue(to).into(INPHACIA));
        actor.should(eventually(seeThat(the(LISTHACIA), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(LISTHACIA));
        actor.attemptsTo(Click.on(INFECHAIDA));
        actor.attemptsTo(SelectTravelDateFrom.withDate(dateFrom));
        actor.attemptsTo(SelectTravelDateTo.withDateFrom(dateFrom).andDateTo(dateTo));
        actor.attemptsTo(wihtAdults(numberAdults).andChildren(numberChildren).andInfants(numberInfants));
        takeScreenshot();
        actor.attemptsTo(Click.on(BTNBUSCARVUELO));


    }

    public static SearchFlight withCityFrom(String from){
        return Tasks.instrumented(SearchFlight.class, from);
    }

    public SearchFlight andCityTo(String to){
        this.to = to;
        return this;
    }

    public SearchFlight andDateFrom(String dateFrom){
        this.dateFrom = dateFrom;
        return this;
    }

    public SearchFlight andDateTo(String dateTo){
        this.dateTo = dateTo;
        return this;
    }

    public SearchFlight andNumberAdults(String numberAdults){
        this.numberAdults = numberAdults;
        return this;
    }

    public SearchFlight andNumberChildren(String numberChildren){
        this.numberChildren = numberAdults;
        return this;
    }

    public SearchFlight andNumberInfants(String numberInfants){
        this.numberInfants = numberInfants;
        return this;
    }

}
