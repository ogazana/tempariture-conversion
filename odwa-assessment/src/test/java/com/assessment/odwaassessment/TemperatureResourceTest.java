package com.assessment.odwaassessment;


import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class TemperatureResourceTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testConvertKelvinToCelsius() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 1)
                .param("temp", "965.00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.is("691.85")));
    }

    @Test
    public void testConvertPoundsToKilograms() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 2)
                .param("temp", "965.00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.is("437.724")));
    }

    @Test
    public void testConvertMilesToKilometers() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 3)
                .param("temp", "100.00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.is("160.934")));
    }

    //----------------------------negative tests------------------------------------------------------------------

    @Test(expected = NestedServletException.class)
    public void testConvertKelvinToCelsiusWhereKelvinIsLessThanZeroExpectError() throws Exception {


        MvcResult c = mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 1)
                .param("temp", "-965.00")).andReturn();
    }


    @Test(expected = NestedServletException.class)
    public void testConvertPoundsToKilogramsWherePoundsIsEqualOrLessThanZeroExpectError() throws Exception {

        MvcResult c = mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 2)
                .param("temp", "-965.00")).andReturn();

    }

    @Test(expected = NestedServletException.class)
    public void testConvertMilesToKilometersWhereMilesIsEqualOrLessThanZeroExpectError() throws Exception {

        MvcResult c = mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 3)
                .param("temp", "0")).andReturn();

    }

    @Test(expected = NestedServletException.class)
    public void testConvertMilesToKilometersWhereOptionIsNotOneOrTwoOrThree() throws Exception {

        MvcResult c = mockMvc.perform(MockMvcRequestBuilders.get("/v1/temperature/{option}/convert", 7)
                .param("temp", "0")).andReturn();

    }

}
