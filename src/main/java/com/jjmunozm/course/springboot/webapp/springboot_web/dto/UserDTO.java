package com.jjmunozm.course.springboot.webapp.springboot_web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank(message = "customer required")
    private String name;
    
}
