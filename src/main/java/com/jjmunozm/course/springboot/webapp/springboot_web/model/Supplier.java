package com.jjmunozm.course.springboot.webapp.springboot_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private int id;

    @NotBlank(message = "name is mandatory") // valida name no venga vacio se usa comunmente para string
    @Size(max = 45)
    private String name;

    @NotBlank
    @Email(message = "El correo electrónico no es válido")
    private String email;

}
