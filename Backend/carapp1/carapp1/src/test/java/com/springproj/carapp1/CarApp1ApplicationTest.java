package com.springproj.carapp1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CarApp1ApplicationTest {

//	@InjectMocks
//	private CarService carService;
//
//	@Mock
//	private CarRepository carRepository;
//
//	@Test
//	public void testGetAllCars() {
//		Car newCar=new Car(3443,"Honda","kj-9090",2009,120000);
//		when(carRepository.findAll()).thenReturn(Arrays.asList(newCar));
//
//
//		List<Car> cars = carService.getAllCars();
//		assertEquals(1,cars.size());
//		assertEquals(newCar.getBrand(),cars.get(0).getBrand());
//		assertEquals(newCar.getModel(),cars.get(0).getModel());
//		assertEquals(newCar.getYear(),cars.get(0).getYear());
//		assertEquals(newCar.getPrice(),cars.get(0).getPrice());
//
//	}
//
//	@Test
//	public void testCreateCar() {
//
//		Car newCar = new Car(3443,"Honda", "kj-9090", 2009, 120000);
//
//		when(carRepository.save(newCar)).thenReturn(newCar);
//		String msg= String.valueOf(carService.storeCar(newCar));
//		assertNotNull(msg);
//
//	}
//
//	@Test
//	public void testUpdateCar(){
//		Car newCar=new Car(3443,"Honda", "kj-9090", 2009, 120000);
//		Car update_car=new Car(3443,"Maruti", "kj-9090", 2009, 120000);
//		when(carRepository.findById(3443)).thenReturn(Optional.of(newCar));
//
//		carService.updateCar(3443,update_car);
//		assertEquals(update_car.getBrand(),newCar.getBrand());
//
//	}
//	@DisplayName("JUnit test for getCarById method")
//	@Test
//	public void testCarById(){
//		Car newCar=new Car(3443,"Honda", "kj-9090", 2009, 120000);
//		given(carRepository.findById(3443)).willReturn(Optional.of(newCar));
//
//
//		Car savedCar = carService.getCarById(newCar.getId()).get();
//		assertThat(savedCar).isNotNull();
//
//	}

}
