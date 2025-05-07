package com.jjmunozm.course.springboot.webapp.springboot_web.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // correlacion de datos - objetos//Instancia DB
@Table(name = "user")
@Data // Getters, Setters, ToString()
@NoArgsConstructor // constructor vacio
@AllArgsConstructor // Inicializa todos los atributos

@NamedQuery(name = "User.findUsersOrderByName",
  query = "select u from User u order by u.name")

public class User {
  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
  private int id;

  @Size(max = 45)
  private String enterprise_id;
  // @NotNull
  // @NotEmpty -> tamaño sea mayor a 0 o ""
  @NotBlank(message = "name is mandatory") // valida name no venga vacio se usa comunmente para string
  @Size(max = 45)
  private String name;
  private String email;
  @DateTimeFormat(pattern = "yyyy-MM-dd") // formato en el cuál queremos almacenar las fechas
  private Date created_at;
  private Date updated_at;

  @PrePersist
  protected void onCreate() {
    this.created_at = new Date();
    this.updated_at = this.created_at;
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated_at = new Date();
  }

  // @Column(columnDefinition="TEXT") para indicar que ese atributo va a almacenar
  // un texto grande
  // private String bio;
}