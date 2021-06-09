package com.avianca.certificacion.prueba.questions;


import net.serenitybdd.screenplay.Question;


import static com.avianca.certificacion.prueba.pages.HomePage.MONTHVISIBLEONE;
import static com.avianca.certificacion.prueba.pages.HomePage.SELECTFECHAIDA;
import static net.serenitybdd.screenplay.questions.Attribute.*;

public class HomeQuestions {

    public static Question<String> valueMonthOne(){
        return actor -> MONTHVISIBLEONE.resolveFor(actor).getText();
    }

    public static Question<Boolean> visibilityMonth(String monthFrom,String yearFrom, String dayFrom){
        return actor -> of(SELECTFECHAIDA).named("visible").viewedBy(actor).asBoolean();
        }
}


