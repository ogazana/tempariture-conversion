package com.assessment.odwaassessment.serviceImpl;

import com.assessment.odwaassessment.enums.ScaleEnum;
import com.assessment.odwaassessment.service.TemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureServiceImpl.class);


    /**
     * Kelvin cannot be less than 0 hence throw exception so as for calculated value of celsuis cannot be less than te defualt value of -273.15
     *
     * @param kelvin
     * @return
     * @throws Exception
     */

    @Override
    public double convertKelvinToCelsius(double kelvin) throws Exception {
        double celsius = 0.0;
        if (kelvin >= 0) {
            celsius = kelvin - ScaleEnum.CELSIUS_SCALE.getScale();
            LOGGER.info("conversion from kelvin " + kelvin + " to celsius = " + celsius + "C");
        } else {
            throw new IllegalArgumentException("Kelvin's lowest scale is 0 and nothing less than 0");
        }
        return Math.round(celsius);
    }

    /**
     * Pounds have to be greater then 0
     *
     * @param pounds
     * @return
     */

    @Override
    public double convertPoundsToKilograms(double pounds) {

        double kilograms = 0.0;
        if (pounds > 0) {
            kilograms = pounds * ScaleEnum.POUND_SCALE.getScale();
            LOGGER.info("conversion from pounds " + pounds + " to kilograms = " + kilograms + "kg");
        } else {

            LOGGER.error("Cannot convert a 0 or negative value of pounds");
            throw new IllegalArgumentException("Cannot convert a 0 or negative value of pounds");
        }
        return Math.round(kilograms);
    }

    /**
     * Miles have to be greater than 0
     *
     * @param miles
     * @return
     */

    @Override
    public double convertMilesToKilometers(double miles) {

        double kilometers = 0.0;
        if (miles > 0) {
            kilometers = miles * ScaleEnum.KILOMETERS_SCALE.getScale();
            LOGGER.info("conversion from miles " + miles + " to kilograms = " + kilometers + "km");
        } else {
            LOGGER.error("Cannot convert a 0 or negative value of miles");
            throw new IllegalArgumentException("Cannot convert a 0 or negative value of miles");
        }
        return Math.round(kilometers);
    }


}
