package com.jjmunozm.course.springboot.webapp.springboot_web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Product.findProductsbyShortName",
query = "select p from Product p where p.description like :descp"
)
@NamedQuery(name = "Product.findProductsOrderByName",
  query = "select p from Product p order by p.description")
@NamedQuery(name = "Product.findProductsRangePrice",
query = "select p from Product p where p.value between :min and :max"
)

public class Product {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private int id;

    @Size(max = 45)
    private String type;

     @Column(columnDefinition="TEXT")
     @NotNull
    private String description;

    @Min(1)
    private double value;

    @Min(1)
    private int max_discount;

    @NotNull
    private boolean avalible;
}
