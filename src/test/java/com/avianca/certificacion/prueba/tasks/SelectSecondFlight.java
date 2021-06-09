package com.avianca.certificacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.avianca.certificacion.prueba.pages.SelectFlightPage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SelectSecondFlight implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.should(eventually(seeThat(the(TXTSELECCIONATUVUELOIDA), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        takeScreenshot();
        actor.attemptsTo(Scroll.to(TXTSELECCIONATUVUELOIDA));
        actor.attemptsTo(Click.on(LINKSEGUNDOVUELOECONOMICAIDA));
        actor.attemptsTo(Scroll.to(OPCIONESCATEGORIADESPLEGADA));
        takeScreenshot();
        actor.should(eventually(seeThat(the(BTNOPCIONECONOMICAM), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(BTNOPCIONECONOMICAM));
        actor.attemptsTo(WaitUntil.the(RESUME, isVisible()));
        actor.should(eventually(seeThat(the(TXTSELECCIONATUVUELOREGRESO), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Scroll.to(TXTSELECCIONATUVUELOREGRESO));
        actor.attemptsTo(Click.on(LINKSEGUNDOVUELOECONOMICAIDA));
        actor.attemptsTo(Scroll.to(OPCIONESCATEGORIADESPLEGADA));
        takeScreenshot();
        actor.should(eventually(seeThat(the(BTNOPCIONECONOMICAM), isVisible())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(BTNOPCIONECONOMICAM));

    }

    public static SelectSecondFlight selectSecondFlight(){
        return Tasks.instrumented(SelectSecondFlight.class);
    }

}
