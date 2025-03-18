package com.chakurte.user_service.dto;

import com.chakurte.user_service.model.Role;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    private int userId;
    private String username;
    private Role role;
    private LocalDateTime loginTime;
    private LocalDateTime expiryTime;
    private String custmizedMessage;


    public String getCustmizedMessage() {
        return custmizedMessage;
    }

    public void setCustmizedMessage(String custmizedMessage) {
        this.custmizedMessage = custmizedMessage;
    }

    public LoginResponse(int userId, String username, Role role, LocalDateTime loginTime, LocalDateTime expiryTime,String custmizedMessage) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.loginTime = loginTime;
        this.expiryTime = expiryTime;
        this.custmizedMessage=custmizedMessage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
