package com.jjmunozm.course.springboot.webapp.springboot_web.repository;


import com.jjmunozm.course.springboot.webapp.springboot_web.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
