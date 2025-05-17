package com.jjmunozm.course.springboot.webapp.springboot_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
