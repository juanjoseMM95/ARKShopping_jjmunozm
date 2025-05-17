package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.UserRepository;
//import lombok.RequiredArgsConstructor;

@Service //se utiliza para llamar al UserRepository donde estan las consultas a la bd
//@RequiredArgsConstructor -> constructor
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository _userRepository){
        this.userRepository = _userRepository;
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public List<User> getUsersFilterByName(String name){
        return userRepository.findByName(name);
    }

    public List<User> getUsersOrderByName(){
        return userRepository.findUsersOrderByName();
    }

    public User newUser(User user){
        return userRepository.save(user);
    }

    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, User user){
        Optional<User> userExist = userRepository.findById(id);
        if(userExist.isPresent()){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(int id){
        Optional<User> userExist = userRepository.findById(id);
        if(userExist.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
