package com.avianca.certificacion.prueba.interactions;

import com.avianca.certificacion.prueba.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.avianca.certificacion.prueba.pages.HomePage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SelectTravelDateTo implements Interaction {

    private String dateFrom, dateTo;

    public SelectTravelDateTo(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Utils utils = new Utils();

        String[] dateSplitFrom = dateFrom.split("-");
        String monthFrom = dateSplitFrom[1];

        String[] dateSplitTo = dateTo.split("-");
        String dayTo = dateSplitTo[0];
        String monthTo = dateSplitTo[1];
        String yearTo = dateSplitTo[2];

        int monthSelectedFrom = utils.MonthFromValue(monthFrom);
        int monthSelectedTo = utils.MonthFromValue(monthTo);

        int difference = Math.abs(monthSelectedFrom - monthSelectedTo);

        if (difference >= 2) {
            for (int i = 0; i < difference; i++) {
                actor.attemptsTo(Click.on(BTNRIGHT));
                actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
            }
        }

        actor.should(eventually(seeThat(the(SELECTFECHAREGRESO.of(monthTo, yearTo, dayTo).called("Date From: " + dateTo)), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(SELECTFECHAREGRESO.of(monthTo, yearTo, dayTo).called("Date From: " + dateTo)));
    }

    public static SelectTravelDateTo withDateFrom(String dateFrom){
        return Tasks.instrumented(SelectTravelDateTo.class,dateFrom);
    }

    public SelectTravelDateTo andDateTo(String dateTo){
        this.dateTo = dateTo;
        return this;
    }

}
