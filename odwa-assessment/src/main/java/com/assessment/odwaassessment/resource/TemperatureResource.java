package com.assessment.odwaassessment.resource;

import com.assessment.odwaassessment.service.TemperatureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TemperatureResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureResource.class);

   @Autowired
    private TemperatureService temperatureService;

    @RequestMapping(value = "/temperature/{option}/convert",
            method = RequestMethod.GET)
    public double convert(@PathVariable("option") final Integer option, @RequestParam("temp") double temp) throws Exception {

        switch (option) {
            case 1:
                return temperatureService.convertKelvinToCelsius(temp);
            case 2:
                return temperatureService.convertPoundsToKilograms(temp);
            case 3:
                return temperatureService.convertMilesToKilometers(temp);
            default:
                LOGGER.error("invalid option");
                throw new IllegalArgumentException("invalid option selected");

        }
    }

    public TemperatureService getTemperatureService() {
        return temperatureService;
    }

    public void setTemperatureService(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }
}
