package com.springproj.carapp1.service;

import Exceptions.CarNotFoundException;
import Exceptions.InvalidRequestException;
import com.springproj.carapp1.entity.Car;
import com.springproj.carapp1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    public Car storeCar(Car car){
        try {
            return carRepo.save(car);
        }catch(Exception e){
            throw new RuntimeException("Failed to store car "+e.getMessage());
        }
    }
    public void deleteCar(int id){
        if (!carRepo.existsById(id)) {
            throw new CarNotFoundException("car not found:"+id);
        }
        carRepo.deleteById(id);
    }

    public List<Car> getAllCars() {
        try {
            return carRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("failed to retrieve cars!");
        }
    }

    public Optional<Car> getCarById(int id){

        return Optional.ofNullable(carRepo.findById(id)
                .orElseThrow(() -> new CarNotFoundException("car not found with id:" + id)));
    }

    public Car updateCar(int id,Car carData) {
        try {
            Car car = carRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("car not found!!"));

            car.setBrand(carData.getBrand());
            car.setModel(carData.getModel());
            car.setYear(carData.getYear());
            car.setPrice(carData.getPrice());
            car.setImage_url(carData.getImage_url());
            return carRepo.save(car);
        } catch (Exception e) {
            throw new InvalidRequestException("Invalid user input for id:" + id + ":" + e.getMessage());
        }
    }
}
