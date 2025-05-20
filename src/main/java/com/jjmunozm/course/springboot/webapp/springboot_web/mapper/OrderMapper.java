package com.jjmunozm.course.springboot.webapp.springboot_web.mapper;

import org.mapstruct.Mapper;

import com.jjmunozm.course.springboot.webapp.springboot_web.dto.OrderDTO;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO orderDTOToOrder(Order order);

    

    
}
