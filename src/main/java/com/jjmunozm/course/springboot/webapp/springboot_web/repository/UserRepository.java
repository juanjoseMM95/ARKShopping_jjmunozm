package com.jjmunozm.course.springboot.webapp.springboot_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;

//findAll() -> select * from user;
//findBy(id) -> select * from user where id = 1;
//save(user) -> insert y update, si tiene id actualiza, caso contrario inserta
//deleteById(id) -> delete from user where id = 1;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email); //select * from user where email = <email>;
}
