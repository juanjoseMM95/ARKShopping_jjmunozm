package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Car;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> allCars(){
        return carRepository.findAll();
    }

    public Car newCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(int id, Car car) {
        Optional<Car> carExist = carRepository.findById(id);
        if (carExist.isPresent()) {
            car.setId(id);
            return carRepository.save(car);
        }
        return null;
    }

    public boolean deleteCar(int id) {
        Optional<Car> carExist = carRepository.findById(id);
        if (carExist.isPresent()) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
