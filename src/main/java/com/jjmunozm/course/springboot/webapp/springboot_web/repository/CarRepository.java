package com.jjmunozm.course.springboot.webapp.springboot_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
