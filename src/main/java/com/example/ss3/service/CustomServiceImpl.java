package com.example.ss3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    UserCustomService userCustomService;
    @Override
    public Integer getUserId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();

        return userCustomService.getUserIdByUsername(username);
    }
}
