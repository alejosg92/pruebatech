package com.avianca.certificacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.avianca.certificacion.prueba.pages.TripSummaryPage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SeeTripSummary implements Task
{
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(eventually(seeThat(the(TXTRESUMENVIAJE), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        takeScreenshot();
        actor.attemptsTo(Scroll.to(RESUMENVUELOIDA));
        takeScreenshot();
        actor.attemptsTo(Ensure.that(CHECKIDA).isDisplayed());
        System.out.println();

        System.out.println("** Vuelo Ida ** ");
        System.out.println("Trayecto:    " + TXTTRAYECTOVUELOIDA.resolveFor(actor).getTextContent());
        System.out.println("Hora Ida:     " + TXTHORASALIDAIDA.resolveFor(actor).getText());
        System.out.println("Hora Llegada: " + TXTHORALLEGADAIDA.resolveFor(actor).getText());
        System.out.println("Tipo Tarifa:  "+ TXTTARIFAIDA.resolveFor(actor).getText());
        System.out.println("Valor:        " + TXTMONTOIDA.resolveFor(actor).getText() + " " + TXTMONEDAIDA.resolveFor(actor).getText());

        actor.attemptsTo(Ensure.that(CHECKREGRESO).isDisplayed());
        System.out.println();
        actor.attemptsTo(Scroll.to(RESUMENVUELOREGRESO));
        takeScreenshot();

        System.out.println("** Vuelo Regreso ** ");
        System.out.println("Trayecto:    " + TXTTRAYECTOVUELOREGRESO.resolveFor(actor).getTextContent());
        System.out.println("Hora Ida:     " + TXTHORASALIDAREGRESO.resolveFor(actor).getText());
        System.out.println("Hora Llegada: " + TXTHORALLEGADAREGRESO.resolveFor(actor).getText());
        System.out.println("Tipo Tarifa:  "+ TXTTARIFAREGRESO.resolveFor(actor).getText());
        System.out.println("Valor:        " + TXTMONTOREGRESO.resolveFor(actor).getText() + " " + TXTMONEDAREGRESO.resolveFor(actor).getText());

        System.out.println();

    }

    public static SeeTripSummary seeTripSummary(){
        return Tasks.instrumented(SeeTripSummary.class);
    }

}
