package com.springproj.carapp1.repository;

import com.springproj.carapp1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

}
