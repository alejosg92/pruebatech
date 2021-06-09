package com.avianca.certificacion.prueba.pages;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static Target BTNCOOKIES = Target.the("Botón Cookies").locatedBy("//BUTTON[@name='cookies-confirm']");

    public static Target BTNRESERVAVUELO = Target.the("Botón Reservar Vuelo").locatedBy("//A[@id='reservatuvuelo']");

    public static Target INDESDE = Target.the("Input Desde").locatedBy("//INPUT[contains(@id,'Origen') and contains(@class,'valid')]");

    public static Target LISTDESDE = Target.the("Primer Item Lista Desde").locatedBy("(//LI[contains(@class,'itemKeySelected')])[1]");

    public static Target INPHACIA = Target.the("Input Hacia").locatedBy("//DIV[@aria-hidden='false']//DIV[contains(@class,'active')]//INPUT[contains(@id,'Destino')]");

    public static Target LISTHACIA = Target.the("Primer Item Lista Hacia").locatedBy("(//LI[contains(@class,'itemKeySelected')])[2]");

    public static Target INFECHAIDA = Target.the("Input Fecha Ida").locatedBy("//INPUT[@data-txt-ida='Ida']");



    //Calendario

    public static Target MONTHVISIBLEONE = Target.the("Month Visible").locatedBy("(//DIV[@aria-hidden='false' and contains(@class,'idaYRegreso')]//DIV[@class='month-container'])[1]");

    public static Target SELECTFECHAIDA = Target.the("Select Fecha Ida").locatedBy("//DIV[@aria-hidden='false' and contains(@class,'idaYRegreso')]//DIV[contains(text(),'{0}') and contains(text(),'{1}')]/ancestor::DIV[@class='month-container']//DIV[@aria-label='{2}']");

    public static Target SELECTFECHAREGRESO = Target.the("Select Fecha Ida").locatedBy("//DIV[@aria-hidden='false' and contains(@class,'idaYRegreso')]//DIV[contains(text(),'{0}') and contains(text(),'{1}')]/ancestor::DIV[@class='month-container']//DIV[@aria-label='{2}']");

    public static Target BTNRIGHT = Target.the("Botón Avanzar Mes").locatedBy("//DIV[@aria-hidden='false' and contains(@class,'idaYRegreso')]//EM[text()='keyboard_arrow_right']");


    //Pasajeros

    public static Target INPPASAJEROS = Target.the("Input Pasajeros").locatedBy("//DIV[@aria-hidden='false']//DIV[contains(@class,'active')]//INPUT[contains(@id,'Pasajeros')]");

    public static Target BTNAGREGARADULTO = Target.the("Botón Agregar Adulto").locatedBy("//DIV[@class='passenger x-plugin float']//DIV[@class='plus control' and @data-property='adults' ]");

    public static Target BTNAGREGARNINO = Target.the("Botón Agregar Niño").locatedBy("//DIV[@class='passenger x-plugin float']//DIV[@class='plus control'and @data-property='child']");

    public static Target BTNAGREGARBEBE = Target.the("Botón Agregar Bebe").locatedBy("//DIV[@class='passenger x-plugin float']//DIV[@class='plus control'and @data-property='infant']");

    public static Target BTNBUSCARVUELO = Target.the("Botón Buscar Vuelos").locatedBy("//DIV[@aria-hidden='false']//DIV[contains(@class,'active')]//BUTTON[text()='Buscar vuelos']");

}
