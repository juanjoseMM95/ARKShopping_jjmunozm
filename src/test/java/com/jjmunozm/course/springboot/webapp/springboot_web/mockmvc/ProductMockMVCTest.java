package com.jjmunozm.course.springboot.webapp.springboot_web.mockmvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjmunozm.course.springboot.webapp.springboot_web.controllers.ProductController;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductMockMVCTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProductService productService;

    @Test
    void testPostMethod() throws Exception {
        Product productTest = new Product((int) 1L, "Descripción del producto", 1200, 15, true, null, null, null);
        when(productService.AddProduct(any())).thenReturn(productTest);
        String request = new ObjectMapper()
                .writeValueAsString(new Product((int) 1L, "Descripción del producto3", 1300, 15, true, null,null, null));
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/products")
                        .contentType(APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn();

                assertThat(mvcResult.getResponse().getContentAsString(),is(not(emptyString())));
    }
}
