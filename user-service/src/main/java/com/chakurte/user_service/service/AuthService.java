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

    @Autowired
    private JwtUtil jwtUtil;

    public Object[] registerUser(RegisterRequest request) {
        Object[] obj=new Object[2];
        Integer flag;
        System.out.println("Password"+request.getPassword());
        if(request.getname().endsWith("@gmail.com")) {
            String encodedPassword = passwordEncoder.encode(request.getPassword());

            User user = new User();
            user.setName(request.getname());
            user.setPassword(encodedPassword);
            user.setRole(request.getRole());

            String uname = user.getName();
            System.out.println("From date base " + userReposatory.findByname(uname).toString());
            System.out.println("from request" + uname);
            try {
                if (userReposatory.findByname(uname).toString().equals(Optional.empty().toString())) {
                    System.out.println("inside if");
                    userReposatory.save(user);
                    String token = jwtUtil.generateToken(user.getName());
                    System.out.println("token gen: " + token);
                    LoginResponse loginResponse=new LoginResponse(user.getId(), user.getName(), user.getRole(), null, null, "user registered successfully");
                    flag=0;
                    obj[0]=loginResponse;
                    obj[1]=flag;
                    return obj;
                } else {
                    System.out.println("User alreday exist");
                    RuntimeException runtimeException=new RuntimeException("userName already exist,please enter unique name");
                    flag=1;
                    obj[0]=runtimeException;
                    obj[1]=flag;
                    return obj;
                }
            } catch (Exception e) {
                System.out.println("User alreday exist");
                RuntimeException runtimeException=new RuntimeException("userName already exist,please enter unique name");
                flag=1;
                obj[0]=runtimeException;
                obj[1]=flag;
                return obj;
            }
        }
        else{
            LoginResponse loginResponse=new LoginResponse(0,null,null,null,null,"invalid username");
            flag=2;
            obj[0]=loginResponse;
            obj[1]=flag;
            return obj;
        }
    }


//    public Optional<User> getUserByEmail(String email) {
//        return userReposatory.findByEmail(email);
//    }


    public Object[] login(String name,String password) {
       Optional<String> byname=userReposatory.findByname(name);
       Object[] obj=new Object[3];
       int flag=0;
       if(!byname.isEmpty()){

           // Fetch password (Optional<String>)
           Optional<String> optionalPass = userReposatory.getPasssword(name);

           // Extract actual password string from Optional
           String encodedPassword = optionalPass.orElseThrow(() -> new RuntimeException("User not found"));

           System.out.println("pass"+encodedPassword);
           if(passwordEncoder.matches(password,encodedPassword)){
               flag=0;
               String token = jwtUtil.generateToken(name);
               String userId=userReposatory.getUserId(name);
               System.out.println("token gen: " + token);
               String resopnse="{\n" +
                       "    \"userId\": \""+userId+"\",\n" +
                       "    \"token\": \""+token+"\"\n" +
                       "}";
               obj[0]=0;
               obj[1]=resopnse;
               obj[2]=flag;
               return obj;
           }else {
               flag=1;
               obj[2]=flag;
               return obj;
           }
       }
        flag=2;
        obj[2]=flag;
        return obj;
    }
    
}
