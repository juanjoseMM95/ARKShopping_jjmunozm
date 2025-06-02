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

import com.jjmunozm.course.springboot.webapp.springboot_web.dto.OrderDTO;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.allOrders());
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id) {
        Order order = orderService.getOrder(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
        return new ResponseEntity<>(orderService.newOrder(order), HttpStatus.CREATED);
    }

    @PostMapping("/dto")
    public ResponseEntity<OrderDTO> addOrderDTO(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(orderService.newOrderExpirable(orderDTO), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
        Order updated = orderService.updateOrder(id, order);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id) ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }

    //Búsqueda de Orders por producto
    @GetMapping("/idProduct/{id}")
    public ResponseEntity<List<OrderDTO>> getMethodName(@PathVariable int id) {
        List<OrderDTO> orders = orderService.getOrdersByProduct(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    
}

