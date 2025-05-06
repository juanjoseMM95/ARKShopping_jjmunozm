package com.jjmunozm.course.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;
import com.jjmunozm.course.springboot.webapp.springboot_web.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserControllerV2 {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.allUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    //@valid en base a las rules de la entidad user
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult result) {
        User createdUser = userService.newUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); 
    }
    
}
