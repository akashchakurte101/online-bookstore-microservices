package com.chakurte.user_service.dto;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name="LoginDetails")
public class LoginSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime localDateTime;

    @Column(nullable = false)
    private LocalDateTime expiryTime;


}
