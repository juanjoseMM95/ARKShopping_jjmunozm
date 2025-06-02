package com.jjmunozm.course.springboot.webapp.springboot_web.mockmvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.jjmunozm.course.springboot.webapp.springboot_web.controllers.OrderController;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.OrderService;

@WebMvcTest(OrderController.class)
public class OrderMockMVCTest {

    @Autowired
	MockMvc mockMvc;

	@MockitoBean
	OrderService orderService;

    @Test
	void testGetMethod() throws Exception {
		when(orderService.allOrders()).thenReturn(List.of(new Order()));
		this.mockMvc.perform(get("/api/orders")).andDo(print()).andExpect(status().isOk());
	}
}
