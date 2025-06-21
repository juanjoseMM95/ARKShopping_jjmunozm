package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import com.jjmunozm.course.springboot.webapp.springboot_web.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.Profile;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public Profile getUserById(int id){
        return profileRepository.findById(id).orElse(null);
    }
}
