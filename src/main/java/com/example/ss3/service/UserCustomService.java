package com.example.ss3.service;

import com.example.ss3.dto.UserDto;
import com.example.ss3.entity.UserEntity;


public interface UserCustomService {
    UserEntity save(UserDto userDto);
}
