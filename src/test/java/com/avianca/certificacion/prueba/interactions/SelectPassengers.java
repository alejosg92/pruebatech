package com.avianca.certificacion.prueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.avianca.certificacion.prueba.pages.HomePage.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SelectPassengers implements Interaction {

    private String numberAdults, numberChildren, numberInfants;

    public SelectPassengers(String numberAdults){
        this.numberAdults = numberAdults;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int adults = Integer.parseInt(numberAdults);
        int children = Integer.parseInt(numberChildren);
        int infants = Integer.parseInt(numberInfants);

        actor.should(eventually(seeThat(the(INPPASAJEROS), isEnabled())).waitingForNoLongerThan(60).seconds().withNoReporting());
        actor.attemptsTo(Click.on(INPPASAJEROS));

        if (adults >= 2){
            for(int i=1 ; i < adults ; i++){
                actor.attemptsTo(Click.on(BTNAGREGARADULTO));
            }
        }

        if (children > 0){
            for(int i=0 ; i < children ; i++){
                actor.attemptsTo(Click.on(BTNAGREGARNINO));
            }
        }

        if (infants > 0){
            for(int i=0 ;i < infants; i++){
                actor.attemptsTo(Click.on(BTNAGREGARBEBE));
            }
        }
    }

    public static SelectPassengers wihtAdults(String numberAdults){
        return Tasks.instrumented(SelectPassengers.class,numberAdults);
    }

    public SelectPassengers andChildren(String numberChildren){
        this.numberChildren = numberChildren;
        return this;
    }

    public SelectPassengers andInfants(String numberInfants){
        this.numberInfants = numberInfants;
        return this;
    }


}
