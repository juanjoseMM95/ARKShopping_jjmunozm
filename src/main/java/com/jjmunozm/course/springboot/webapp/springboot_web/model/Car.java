package com.jjmunozm.course.springboot.webapp.springboot_web.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
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

}
