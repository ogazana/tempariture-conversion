package com.assessment.odwaassessment.service;


public interface TemperatureService {

    double convertKelvinToCelsius(double kelvin) throws Exception;

    double convertPoundsToKilograms(double pounds);

    double convertMilesToKilometers(double miles);
}
