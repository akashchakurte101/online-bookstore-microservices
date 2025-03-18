package com.chakurte.user_service.controller;

import com.chakurte.user_service.dto.LoginResponse;
import com.chakurte.user_service.dto.RegisterRequest;
import com.chakurte.user_service.model.User;
import com.chakurte.user_service.service.AuthService;
import com.chakurte.user_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/reg")
    public ResponseEntity<Object> registerUser(@RequestBody RegisterRequest request){
        Object[] response=authService.registerUser(request);
        if(response[1].equals(0)){
            return ResponseEntity.status(HttpStatus.CREATED).body(response[0]);
        } else if (response[1].equals(1)) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("user already exist");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid username");
        }
    }


    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String name, @RequestParam String password){
        Object[] obj =authService.login(name,password);

        if(obj[2].equals(0)){
            System.out.println("obj  value --> "+obj[1]);
            return ResponseEntity.status(HttpStatus.valueOf(200)).body(obj[1]);
        } else if (obj[2].equals(1)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("pawword is incorect");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("incorrect username");
        }
    }

//    @GetMapping("/{eamil}")
//    public User getUserByEmail(@PathVariable String email){
//            return authService.getUserByEmail(email).orElse(null);
//
//    }
}
