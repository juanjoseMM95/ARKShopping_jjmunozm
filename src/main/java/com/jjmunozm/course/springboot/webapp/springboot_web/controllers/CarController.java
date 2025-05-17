package com.jjmunozm.course.springboot.webapp.springboot_web.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Car;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.CarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(carService.allCars());
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        Car car = carService.getCar(id);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
        return new ResponseEntity<>(carService.newCar(car), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car car) {
        Car updated = carService.updateCar(id, car);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        return carService.deleteCar(id) ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }
}
