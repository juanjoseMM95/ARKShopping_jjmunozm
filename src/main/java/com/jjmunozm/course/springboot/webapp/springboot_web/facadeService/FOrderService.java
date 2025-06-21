package com.jjmunozm.course.springboot.webapp.springboot_web.facadeService;

import com.jjmunozm.course.springboot.webapp.springboot_web.dto.OrderDTO;
import com.jjmunozm.course.springboot.webapp.springboot_web.mapper.OrderMapper;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.OrderService;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.OrderServicePrivate;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FOrderService {

    private final UserService userService;
    private final OrderService orderService;
    private final OrderServicePrivate orderServicePrivate;
    private final OrderMapper orderMapper;

    public List<Order> getOrderByUserId(String enterpriseId){
        //Profile identification
        User user = userService.getUserByEnterpriseId(enterpriseId);
        if(user == null){ return null;}

        List<Order> orders = new ArrayList<>();
        List<OrderDTO> ordersDTO = new ArrayList<>();

        Boolean profileId = user.getProfile().isAdmin();
        if(profileId){
            return orderServicePrivate.GetOrdersPrivateInformation(user.getId());
        }else{
            return orderMapper.ordersDTOToOrders(orderService.getOrdersByUser(user.getId()));
        }

    }
}
