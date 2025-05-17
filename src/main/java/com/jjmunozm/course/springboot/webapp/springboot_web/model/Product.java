package com.jjmunozm.course.springboot.webapp.springboot_web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

@NamedQuery(name = "Product.findProductsByCategory",
query = "select p from Product p where p.category.id = :id_category"
)

public class Product {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private int id;

     @Column(columnDefinition="TEXT")
     @NotNull
    private String description;

    @Min(1)
    private double value;

    @Min(1)
    private int max_discount;

    @NotNull
    private boolean avalible;

    //relacion con entidad Category, FK
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "product_category")
    private Category category;

    //relacion con n:m con Order
    //@JsonBackReference(value = "product_order")
    @ManyToMany
    @JoinTable(
      name = "orders_has_products",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Order> orders;

}
