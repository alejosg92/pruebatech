package com.avianca.certificacion.prueba.pages;

import net.serenitybdd.screenplay.targets.Target;

public class SelectFlightPage {

    public static Target TXTSELECCIONATUVUELOIDA = Target.the("Selecciona Tu Vuelo Ida").locatedBy("//H1[text()='Selecciona tu vuelo de ida']");

    public static Target TXTSELECCIONATUVUELOREGRESO = Target.the("Selecciona Tu Vuelo Regreso").locatedBy("//H1[text()='Selecciona tu vuelo de regreso']");

    public static Target LINKSEGUNDOVUELOECONOMICAIDA = Target.the("Link Mostrar Opciones Vuelo Economica Ida").locatedBy("(//DIV[@class='flight-container'])[2]//DIV[contains(@class,'cabin-economy')]//I[contains(text(),'expand_more')]");

    public static Target OPCIONESCATEGORIADESPLEGADA = Target.the("Contenedor de Opciones Desplegadas").locatedBy("//DIV[@class='expander-content']");

    public static Target BTNOPCIONECONOMICAM = Target.the("Botón Selección Economica Talla M").locatedBy("//DIV[@class='expander-content']//DIV[contains(@class,'family-M ')]//DIV[@class='ff-attributes']//BUTTON");

    public static Target RESUME = Target.the("Resumen Vuelo Ida").locatedBy("//DIV[@class='resume']");


}
