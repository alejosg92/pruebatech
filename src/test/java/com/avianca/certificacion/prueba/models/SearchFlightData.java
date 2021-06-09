package com.avianca.certificacion.prueba.models;

import java.util.ArrayList;
import java.util.List;

public class SearchFlightData {

    private String from, to, dateFrom, dateTo, numberAdults, numberChildren, numberInfants;

    public static List<SearchFlightData> searchFlightDataList = new ArrayList<>();

    public static void SaveSearchFlightData(SearchFlightData searchFlightData){
        searchFlightDataList.add(searchFlightData);
    }

    public static void EmptyList(){
        searchFlightDataList = new ArrayList<>();
    }

    public static SearchFlightData readData(int index){
        return searchFlightDataList.get(index);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getNumberAdults() {
        return numberAdults;
    }

    public void setNumberAdults(String numberAdults) {
        this.numberAdults = numberAdults;
    }

    public String getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(String numberChildren) {
        this.numberChildren = numberChildren;
    }

    public String getNumberInfants() {
        return numberInfants;
    }

    public void setNumberInfants(String numberInfants) {
        this.numberInfants = numberInfants;
    }

}
