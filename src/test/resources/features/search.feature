Feature: Select a flight
  As User
  I want search a flight
  To see flight options

  @prueba
  Scenario Outline: Search a flight
    Given User visits Home of Avianca Page
    When Search a flight
      |from|to|dateFrom|dateTo|numberAdults|numberChildren|numberInfants|
    And Select the second option of flights
    Then See the trip Summary

    Examples:
      |Data|
      ##@externaldata@./src/test/resources/datadriven/data.xlsx@searchflight