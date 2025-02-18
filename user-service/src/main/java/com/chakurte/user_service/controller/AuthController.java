package com.chakurte.user_service.controller;

import com.chakurte.user_service.dto.LoginResponse;
import com.chakurte.user_service.dto.RegisterRequest;
import com.chakurte.user_service.model.User;
import com.chakurte.user_service.service.AuthService;
import com.chakurte.user_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/reg")
    public Object registerUser(@RequestBody RegisterRequest request){
//        System.out.println(user.toString());
        return  authService.registerUser(request);
    }

    public LoginResponse login(@RequestBody RegisterRequest request){
        return authService.login(request);
    }

    @GetMapping("/{eamil}")
    public User getUserByEmail(@PathVariable String email){
            return authService.getUserByEmail(email).orElse(null);

    }
}
