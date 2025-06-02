package com.jjmunozm.course.springboot.webapp.springboot_web.model;


import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderExpirable extends Order {
    private Date Expirable;
}
