package com.springproj.carapp1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproj.carapp1.entity.Car;
import com.springproj.carapp1.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CarControllerTest {


    private MockMvc mockMvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private Car car;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
       car = new Car(6776,"VW","sk-09",2022,230000,"https://m.atcdn.co.uk/vms/media/w1920/3ab03f662c7b484e8ea446e26fc6e609.jpg");
    }

    @Test
    public void testGetAllCars() throws Exception {
        when(carService.getAllCars()).thenReturn(Arrays.asList(car));

        mockMvc.perform(get("/cars/catalog"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetCarById() throws Exception {
        when(carService.getCarById(6776)).thenReturn(Optional.of(car));

        mockMvc.perform(get("/cars/{id}",6776)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand", is(car.getBrand())));
    }

    @Test
    public void testCreateCar() throws Exception {
        when(carService.storeCar(any(Car.class))).thenReturn(car);

        mockMvc.perform(post("/cars/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(car)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.brand", is(car.getBrand())));

    }

    @Test
    public void testUpdateCar() throws Exception {
        Car updatedCar = new Car(6776, "Honda", "Accord", 2024, 320000,"https://m.atcdn.co.uk/vms/media/w1920/3ab03f662c7b484e8ea446e26fc6e609.jpg");
        when(carService.updateCar(eq(6776), any(Car.class))).thenReturn(updatedCar);

        mockMvc.perform(put("/cars/edit/{id}",6776)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updatedCar)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.brand", is("Honda")))
                        .andExpect(jsonPath("$.model", is("Accord")))
                        .andExpect(jsonPath("$.year", is(2024)))
                        .andExpect(jsonPath("$.price", is(320000)));
    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
