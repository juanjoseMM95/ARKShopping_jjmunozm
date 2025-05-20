package com.jjmunozm.course.springboot.webapp.springboot_web.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private int id;

    @Min(1)
    private double totalAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // formato en el cuál queremos almacenar las fechas
    private Date date;

    private User user;

    private List<Product> products;

}
