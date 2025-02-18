package com.chakurte.user_service.dao;

import com.chakurte.user_service.dto.LoginSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginSessionReposatory extends JpaRepository<LoginSession,Integer> {

}
