package com.springproj.carapp1.controller;

import com.springproj.carapp1.service.CarService;
import com.springproj.carapp1.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins="*")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car savedCar= carService.storeCar(car);
        return ResponseEntity.ok(savedCar);
    }

    @GetMapping("/catalog")
    public ResponseEntity<List<Car>> getCatalog(){
        List<Car> cars=  carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable int id){
        Optional<Car> car= carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Car> updateCarData(@PathVariable int id,@RequestBody Car carData){
        Car updatedCar= carService.updateCar(id,carData);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable int id){

        carService.deleteCar(id);
    }
}


