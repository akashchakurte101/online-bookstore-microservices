package com.chakurte.user_service.dao;

import com.chakurte.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReposatory extends JpaRepository<User,Integer> {

    @Query("select u from User u where email= :email")
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByUsername(String username);

    @Query("select u from ")
    void find();
}
