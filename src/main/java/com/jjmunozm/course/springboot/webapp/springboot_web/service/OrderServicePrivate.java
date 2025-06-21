package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.OrderRepository;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.interfaces.PrivateOrderInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServicePrivate implements PrivateOrderInformation {

    private final OrderRepository orderRepository;

    public List<Order> GetOrdersPrivateInformation(Integer id_user){
        return orderRepository.findOrdersByUserId(id_user);
    }
}
