package com.avianca.certificacion.prueba.pages;

import net.serenitybdd.screenplay.targets.Target;

public class TripSummaryPage {

    public static Target TXTRESUMENVIAJE = Target.the("Text Resume Viaje").locatedBy("//H1[text()='Resumen de viaje']");


    public static Target RESUMENVUELOIDA = Target.the("Resumen Vuelo Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]");

    public static Target TXTTRAYECTOVUELOIDA = Target.the("Trayecto Vuelo Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//DIV[@class='header-content cities']");

    public static Target TXTHORASALIDAIDA = Target.the("Text Hora de Salida Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//DIV[@class='flight-time']//DIV[1]");

    public static Target TXTHORALLEGADAIDA = Target.the("Text Hora de Llegada Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//DIV[@class='flight-time']//DIV[3]");

    public static Target TXTTARIFAIDA = Target.the("Text Tarifa Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//B[@class='fare-type']");

    public static Target TXTMONTOIDA = Target.the("Text Monto Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//SPAN[@class='amount']");

    public static Target TXTMONEDAIDA = Target.the("Text Moneda").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//DIV[@class='price-section']//SPAN[@class='currency']");

    public static Target CHECKIDA = Target.the("Check Ida").locatedBy("//SPAN[contains(text(),'Vuelo de ida ')]//ancestor::DIV[4]//I[text()='done']");



    public static Target RESUMENVUELOREGRESO = Target.the("Resumen Vuelo Regreso").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]");

    public static Target TXTTRAYECTOVUELOREGRESO = Target.the("Trayecto Vuelo Ida").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//DIV[@class='header-content cities']");

    public static Target TXTHORASALIDAREGRESO = Target.the("Text Hora de Salida Ida").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//DIV[@class='flight-time']//DIV[1]");

    public static Target TXTHORALLEGADAREGRESO = Target.the("Text Hora de Llegada Ida").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//DIV[@class='flight-time']//DIV[3]");

    public static Target TXTTARIFAREGRESO = Target.the("Text Tarifa Ida").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//B[@class='fare-type']");

    public static Target TXTMONTOREGRESO = Target.the("Text Monto Ida").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//SPAN[@class='amount']");

    public static Target TXTMONEDAREGRESO = Target.the("Text Moneda").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//DIV[@class='price-section']//SPAN[@class='currency']");

    public static Target CHECKREGRESO = Target.the("Check Regreso").locatedBy("//SPAN[contains(text(),' Vuelo de regreso' )]//ancestor::DIV[4]//I[text()='done']");


}
