package com.springproj.carapp1.service;


import com.springproj.carapp1.entity.Car;
import com.springproj.carapp1.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    private Car car;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        car = new Car(6776,"VW","sk-09",2022,230000,"https://m.atcdn.co.uk/vms/media/w1920/3ab03f662c7b484e8ea446e26fc6e609.jpg");
    }

    @Test
    public void testGetAllCars(){
        List<Car> cars= Arrays.asList(car);
        when(carRepository.findAll()).thenReturn(cars);

        List<Car> result=carService.getAllCars();
        assertNotNull(result);
        assertEquals(1,result.size());
        assertEquals(car,result.get(0));

        verify(carRepository,times(1)).findAll();
    }

    @Test
    public void testCreateCar() {

        when(carRepository.save(car)).thenReturn(car);
        Car result=carService.storeCar(car);
        assertNotNull(result);
        assertEquals(car,result);
        verify(carRepository,times(1)).save(car);
    }

    @Test
    public void testUpdateCar(){
        Car updatedCar=new Car(6776,"Honda", "kj-9090", 2009, 120000,"https://m.atcdn.co.uk/vms/media/w1920/3ab03f662c7b484e8ea446e26fc6e609.jpg");
        when(carRepository.findById(6776)).thenReturn(Optional.of(car));
        when(carRepository.save(car)).thenReturn(car);

        carService.updateCar(6776,updatedCar);
        assertEquals(updatedCar.getBrand(),car.getBrand());
        assertEquals(updatedCar.getModel(),car.getModel());
        assertEquals(updatedCar.getYear(),car.getYear());
        assertEquals(updatedCar.getPrice(),car.getPrice());
        verify(carRepository,times(1)).findById(6776);
        verify(carRepository,times(1)).save(car);

    }

    @Test
    public void testCarById(){
        when(carRepository.findById(6776)).thenReturn(Optional.of(car));

        Car savedCar = carService.getCarById(car.getId()).get();
        assertThat(savedCar).isNotNull();

        verify(carRepository,times(1)).findById(6776);
    }


}
