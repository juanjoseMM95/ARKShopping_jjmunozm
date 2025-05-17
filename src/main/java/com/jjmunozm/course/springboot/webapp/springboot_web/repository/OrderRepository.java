package com.jjmunozm.course.springboot.webapp.springboot_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
 List<Order> findOrdersByIdProduct(@Param("id_product") int id);
}
