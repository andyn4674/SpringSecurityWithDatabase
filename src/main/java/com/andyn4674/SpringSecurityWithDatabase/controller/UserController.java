package com.andyn4674.SpringSecurityWithDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andyn4674.SpringSecurityWithDatabase.model.Users;
import com.andyn4674.SpringSecurityWithDatabase.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user)
    {
        return service.register(user);
    }

}
