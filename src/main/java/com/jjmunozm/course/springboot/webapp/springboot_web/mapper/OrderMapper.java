package com.jjmunozm.course.springboot.webapp.springboot_web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.jjmunozm.course.springboot.webapp.springboot_web.dto.OrderDTO;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;

@Mapper(componentModel="spring")
public interface OrderMapper {

    @Mapping(target="userName",source="user.name")
    @Mapping(target="productsId",source="products",qualifiedByName = "mapProductsToIds")
    OrderDTO orderToOrderDTO(Order order);

    List<OrderDTO> ordersToOrdersDTO(List<Order> orders);

    @Named("mapProductsToIds")
    default List<Integer> mapProductsToIds(List<Product> products) {
        return products.stream()
                       .map(Product::getId) // Asumiendo que Product tiene un método getId()
                       .collect(Collectors.toList());
    }


}
