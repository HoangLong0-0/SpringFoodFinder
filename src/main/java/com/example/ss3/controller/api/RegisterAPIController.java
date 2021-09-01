package com.example.ss3.controller.api;

import com.example.ss3.dto.CartDto;
import com.example.ss3.dto.ItemDto;
import com.example.ss3.dto.UserDto;
import com.example.ss3.model.BaseResponse;
import com.example.ss3.service.UserCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/register")
public class RegisterAPIController {
    @Autowired
    private UserCustomService userCustomService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto){
        BaseResponse res = new BaseResponse();
        res.data = userCustomService.save(userDto);
        return  ResponseEntity.ok(res);
    }
}
