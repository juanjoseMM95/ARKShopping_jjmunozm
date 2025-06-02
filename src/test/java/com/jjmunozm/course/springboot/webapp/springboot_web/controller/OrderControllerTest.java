package com.jjmunozm.course.springboot.webapp.springboot_web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.jjmunozm.course.springboot.webapp.springboot_web.controllers.OrderController;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Order;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.OrderService;

//prueba unitaria
public class OrderControllerTest {

    //Doble de prueba
    @Mock
    OrderService orderService;

    //sujeto de prueba
    @InjectMocks
    OrderController orderController;

    @BeforeEach//Para ejecutar este método antes de cada una de las pruebas
	public void setup() {
		MockitoAnnotations.openMocks(this);// Pedirle a mockito que procese las anotaciones
	}

    @Test
    public void testReturningOrders(){
        //Arrange (Arreglar)
        when(orderService.allOrders()).thenReturn(List.of(new Order()));
        //Act(Actuar)
        ResponseEntity<List<Order>> responseEntity = orderController.getOrders();
        //Assert(Validar)
        Order expectedOrder = new Order();
        
        assertEquals(List.of(expectedOrder),responseEntity.getBody());
    }

    		// Body Not Null
		/*assertNotNull(responseEntity.getBody());
		// Body Size
		assertEquals(1, responseEntity.getBody().size());
		// Response Body Id
		assertEquals(1l, responseEntity.getBody().get(0).getId());
		// Response Body ClientId
		assertEquals("Order DTO 1", responseEntity.getBody().get(0).getClientId());
		// Response Body Products
		assertNull(responseEntity.getBody().get(0).getProducts());*/

}
