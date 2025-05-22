package com.jjmunozm.course.springboot.webapp.springboot_web.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedQuery(name = "Order.findOrdersByIdProduct",
query = "select o from Order o JOIN o.products p WHERE p.id = :id_product"
)

@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id"
)
public class Order {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private int id;

    @Min(1)
    private double totalAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // formato en el cuál queremos almacenar las fechas
    private Date date;

    @PrePersist
    protected void onCreate() {
        this.date = new Date();
    }

    @NotNull
    private boolean send;

    //relacion con entidad User, FK
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //relacion n:m con entidad Product
    //@JsonManagedReference(value = "product_order")
    @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
        name="orders_has_products",
        joinColumns = @JoinColumn(name ="order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    private List<Product> products;
    
}
