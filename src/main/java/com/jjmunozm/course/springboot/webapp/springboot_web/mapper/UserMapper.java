package com.jjmunozm.course.springboot.webapp.springboot_web.mapper;
import org.mapstruct.Mapper;

import com.jjmunozm.course.springboot.webapp.springboot_web.dto.UserDTO;
import com.jjmunozm.course.springboot.webapp.springboot_web.model.User;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
    
}





