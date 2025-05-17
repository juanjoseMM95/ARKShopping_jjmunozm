package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.OrderRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public List<Order> allOrders(){
        return orderRepository.findAll();
    }

    public Order newOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(int id, Order order) {
        Optional<Order> orderExist = orderRepository.findById(id);
        if (orderExist.isPresent()) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    public boolean deleteOrder(int id) {
        Optional<Order> orderExist = orderRepository.findById(id);
        if (orderExist.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Order> getOrdersByProduct(int id_product){
        return orderRepository.findOrdersByIdProduct(id_product);
    }

}
