package com.avianca.certificacion.prueba.utils;

public class Utils {


    public int MonthFromValue(String monthFrom){

        int monthFromValue = 0;

        switch (monthFrom) {
            case "Enero":
                monthFromValue = 1;
                break;

            case "Febrero":
                monthFromValue = 2;
                break;

            case "Marzo":
                monthFromValue = 3;
                break;

            case "Abril":
                monthFromValue = 4;
                break;

            case "Mayo":
                monthFromValue = 5;
                break;

            case "Junio":
                monthFromValue = 6;
                break;

            case "Julio":
                monthFromValue = 7;
                break;

            case "Agosto":
                monthFromValue = 8;
                break;

            case "Septiembre":
                monthFromValue = 9;
                break;

            case "Octubre":
                monthFromValue = 10;
                break;

            case "Noviembre":
                monthFromValue = 11;
                break;

            case "Diciembre":
                monthFromValue = 12;
                break;
        }

        return monthFromValue;
    }
}
