package com.jjmunozm.course.springboot.webapp.springboot_web.service.interfaces;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;

import java.util.List;

public interface PrivateOrderInformation {

    List<Order> GetOrdersPrivateInformation(Integer orderId);
}
