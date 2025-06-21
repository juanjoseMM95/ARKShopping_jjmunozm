package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Profile;

@Service //se utiliza para llamar al UserRepository donde estan las consultas a la bd
@RequiredArgsConstructor //-> constructor
public class UserService {
    private final UserRepository userRepository;
    private final ProfileService profileService;

//    public UserService(UserRepository _userRepository){
//        this.userRepository = _userRepository;
//    }

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
        Profile profile = profileService.getUserById(user.getProfile().getId());
        user.setProfile(profile);
        return userRepository.save(user);
    }

    public User getUserByEnterpriseId(String enterpriseId) {
        return userRepository.findByEnterprise_id(enterpriseId);
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
