package com.binaryCars.horses.web;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
  @Autowired

  private CarService carService;
  @GetMapping("/cars")
  public ResponseEntity<List<Car>> getCars(){

    return new ResponseEntity<>
            (carService.getCars()
            , HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Car> getCarById(@PathVariable Long id){
    return new ResponseEntity<>(carService.getCarById(id),HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<Car> saveCar(@RequestBody Car car){
    return new ResponseEntity<>(carService.saveCar(car),HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Car> updateCar(@PathVariable Long id,@RequestBody Car car){
    return new ResponseEntity<>(carService.updateCar(id,car),HttpStatus.ACCEPTED);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Car> deleteCar(@PathVariable Long id){
    carService.deleteCar(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
