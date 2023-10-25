package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;

import java.util.List;

public interface CarService {
    //get all the cars
    List<Car> getCars();

    Car getCarById(Long id);

    Car saveCar(Car car);

    Car updateCar(Long id, Car car);

    void deleteCar(Long id);
}
