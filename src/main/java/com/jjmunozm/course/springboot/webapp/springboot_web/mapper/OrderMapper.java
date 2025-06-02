package com.jjmunozm.course.springboot.webapp.springboot_web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jjmunozm.course.springboot.webapp.springboot_web.service.OrderService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.jjmunozm.course.springboot.webapp.springboot_web.dto.OrderDTO;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.OrderExpirable;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;

    @Mapper(componentModel="spring")
    public interface OrderMapper {



        @Mapping(target="userName",source="user.name")
        @Mapping(target="productsId",source="products",qualifiedByName = "mapProductsToIds")
        @Mapping(target = "expirationDate", ignore = true)
        OrderDTO orderToOrderDTO(Order order);

        List<OrderDTO> ordersToOrdersDTO(List<Order> orders);

        @Named("mapProductsToIds")
        default List<Integer> mapProductsToIds(List<Product> products) {
            if (products == null){
                return List.of();
            }
            return products.stream()
                           .map(Product::getId) // Asumiendo que Product tiene un método getId()
                           .collect(Collectors.toList());
        }

        OrderExpirable expirableOrderToOrder(OrderDTO orderDTO);

        Order orderDTOToOrder(OrderDTO orderDTO);
    }
