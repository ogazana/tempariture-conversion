package com.assessment.odwaassessment;

import com.assessment.odwaassessment.service.TemperatureService;
import com.assessment.odwaassessment.serviceImpl.TemperatureServiceImpl;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureServiceImplTest {

    @Mock
    private TemperatureService temperatureService;

    @Before
    public void before() {
        temperatureService = new TemperatureServiceImpl();
    }

    @Test
    public void testConvertKelvinToCelsius() throws Exception {

        double conversion = temperatureService.convertKelvinToCelsius(965.00);

        Assert.assertThat(conversion, new IsEqual(691.85));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertKelvinToCelsiusWhereKelvinIsLessThanZeroExpectError() throws Exception {

        temperatureService.convertKelvinToCelsius(-965.00);

    }


    @Test
    public void testConvertPoundsToKilograms() {
        double conversion = temperatureService.convertPoundsToKilograms(965.00);

        Assert.assertThat(conversion, new IsEqual(437.724));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertPoundsToKilogramsWherePoundsIsEqualOrLessThanZeroExpectError() {

        temperatureService.convertPoundsToKilograms(-965.00);

    }

    @Test
    public void testConvertMilesToKilometers() {

        double conversion = temperatureService.convertMilesToKilometers(100);

        Assert.assertThat(conversion, new IsEqual(160.934));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConvertMilesToKilometersWhereMilesIsEqualOrLessThanZeroExpectError() {

        temperatureService.convertMilesToKilometers(0);

    }
}
