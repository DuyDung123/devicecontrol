package com.laptrinhjavaweb.devicecontrol.converter;

import com.laptrinhjavaweb.devicecontrol.dto.UserDTO;
import com.laptrinhjavaweb.devicecontrol.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity toEntity(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(dto.getUsername());
        userEntity.setFullName(dto.getFullname());
        userEntity.setPassword(dto.getPassword());
        return  userEntity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setUsername(entity.getUserName());
        userDTO.setFullname(entity.getFullName());
        userDTO.setPassword(entity.getPassword());
        return userDTO;
    }
}
