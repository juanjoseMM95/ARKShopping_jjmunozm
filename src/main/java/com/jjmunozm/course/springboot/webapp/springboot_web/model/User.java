package com.jjmunozm.course.springboot.webapp.springboot_web.model;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

@NamedQuery(name = "User.findByEnterprise_id",
query = "select u from User u where u.enterprise_id = :enterprise_id")

@JsonIgnoreProperties("orders")
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

  //relacion con entidad Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

  // @Column(columnDefinition="TEXT") para indicar que ese atributo va a almacenar

  @ManyToOne
  @JoinColumn(name = "profile_id")
  @JsonBackReference(value = "user_profile")
  private Profile profile;
}