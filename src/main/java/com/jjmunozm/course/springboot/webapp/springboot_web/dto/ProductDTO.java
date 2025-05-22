package com.jjmunozm.course.springboot.webapp.springboot_web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
     private int id;
     private String description;
     private double value;
     private int max_discount;
     private boolean avalible;
     private String categoryName;
     private List<Integer> orders;
}
