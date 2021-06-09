package com.avianca.certificacion.prueba.interactions;

import com.avianca.certificacion.prueba.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;

import java.time.LocalDate;

import static com.avianca.certificacion.prueba.pages.HomePage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SelectTravelDateFrom implements Interaction {

    private String dateFrom;

    public SelectTravelDateFrom(String dateFrom){
        this.dateFrom = dateFrom;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Utils utils = new Utils();

        String[] dateSplit = dateFrom.split("-");
        String dayFrom = dateSplit[0];
        String monthFrom = dateSplit[1];
        String yearFrom = dateSplit[2];
        LocalDate today = LocalDate.now();

        int monthSelectedValue = utils.MonthFromValue(monthFrom);
        int month = today.getMonthValue();
        int difference = Math.abs(month - monthSelectedValue);

        if (difference >= 2) {
            for (int i = 0; i<difference; i++ ){
                actor.attemptsTo(Click.on(BTNRIGHT));
                actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
            }
        }

        actor.should(eventually(seeThat(the(SELECTFECHAIDA.of(monthFrom,yearFrom,dayFrom).called("Date From: "+ dateFrom)), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(SELECTFECHAIDA.of(monthFrom,yearFrom,dayFrom).called("Date From: "+ dateFrom)));
    }

    public static SelectTravelDateFrom withDate(String dateFrom){
        return Tasks.instrumented(SelectTravelDateFrom.class, dateFrom);
    }

}
