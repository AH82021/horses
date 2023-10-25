package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.exception.ResourceNotFoundException;
import com.binaryCars.horses.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such car found with id " + id));
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car existingCar = getCarById(id);
        existingCar.setMake(car.getMake());
        existingCar.setModel(car.getModel());
        existingCar.setColor(car.getColor());
        existingCar.setRegisterNumber(car.getRegisterNumber());
        existingCar.setYear(car.getYear());
        existingCar.setPrice(car.getPrice());
carRepository.save(existingCar);
        return existingCar;
    }

    @Override
    public void deleteCar(Long id) {

        carRepository.deleteById(id);
    }
}
