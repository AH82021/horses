package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


class CarServiceImplTest {
    @Mock
private CarRepository carRepository;
@InjectMocks
    private CarServiceImpl carService;
 @BeforeEach
 public void setUp() throws Exception {
     MockitoAnnotations.openMocks(this).close();
 }
 @Test
 public void shouldReturnAllCars(){
     //Given
     List<Car> expectedCars = new ArrayList<>();
     expectedCars.add(new Car());
     expectedCars.add(new Car());
     Mockito.when(carRepository.findAll()).thenReturn(expectedCars);

     // When
     List<Car> actualCars = carService.getCars();

     //Then

     assertThat(actualCars).isEqualTo(expectedCars);
 }
 @Test
 public void shouldSaveCar(){
     //Given
     Car car = new Car();
     //When
     carService.saveCar(car);
     //Then
     verify(carRepository).save(car);
 }
@Test
 public void shouldUpdateCar(){
     //Given
     Long id = 1L;
     Car car = new Car();
     Car car1 = new Car(id, "Toyota", "Corolla", "Red", "tc-303", 2022, 234566);
     //Mock
     Mockito.when(carRepository.findById(id)).thenReturn(Optional.of(car));
     //When

     carService.updateCar(id, car1);

     //Then
     verify(carRepository).save(car);
     assertEquals(car.getMake(),"Toyota");
    assertEquals(car.getModel(),"Corolla");

 }



}