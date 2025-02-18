package com.chakurte.user_service.service;

import com.chakurte.user_service.dao.LoginSessionReposatory;
import com.chakurte.user_service.dao.UserReposatory;
import com.chakurte.user_service.dto.LoginResponse;
import com.chakurte.user_service.dto.RegisterRequest;
import com.chakurte.user_service.model.User;
import com.chakurte.user_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserReposatory userReposatory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private JwtUtil jwtUtil;

    public Object registerUser(RegisterRequest request) {
        String encodedPassword=passwordEncoder.encode(request.getPassword());

        User user=new User();
        user.setName(request.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(request.getRole());

        String uname=user.getName();
        try {
            if (userReposatory.findByUsername(uname) != null) {
                userReposatory.save(user);
                String token= jwtUtil.generateToken(user.getName());
                return new LoginResponse(user.getId(), user.getName(), user.getRole(),"user registered successfully");
            }
        } catch (Exception e) {
            return new RuntimeException("userName already exist,please enter unique name");
        }

       return null;

    }


    public Optional<User> getUserByEmail(String email) {
        return userReposatory.findByEmail(email);
    }


    public LoginResponse login(RegisterRequest request) {
        LoginSessionReposatory.find();
    }
}
