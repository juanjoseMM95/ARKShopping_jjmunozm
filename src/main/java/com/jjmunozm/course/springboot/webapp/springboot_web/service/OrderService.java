package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.OrderRepository;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.ProductRepository;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Order> allOrders(){
        return orderRepository.findAll();
    }

    public Order newOrder(Order order) {
        int idUser = order.getUser().getId();
        //recuperar usuario
        User user = userRepository.findById(idUser).orElse(null);

        //recuperar productos
        List<Product> products = order.getProducts().stream()
        .map(product -> productRepository.findById(product.getId())
            .orElseThrow(null))
        .collect(Collectors.toList());

        if(user != null){
            order.setUser(user);
            order.setProducts(products);
            return orderRepository.save(order);
        }else{
            return null;
        }
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
