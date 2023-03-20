package com.example.cinema.mapper;

import com.example.cinema.dto.UserDto;
import com.example.cinema.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToDto(UserEntity userEntity) {
        return UserDto
                .builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .build();
    }
}
