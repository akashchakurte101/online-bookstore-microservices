package com.chakurte.user_service.dao;

import com.chakurte.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserReposatory extends JpaRepository<User,Integer> {

//    @Query("select u from Users u where email= :email")
//    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "SELECT name FROM users WHERE name = :name", nativeQuery = true)
    Optional<String> findByname(@Param("name") String name);

    @Query(value ="select password from users where name= :name",nativeQuery = true)
    Optional<String> getPasssword(@Param("name") String name);

    @Query(value ="select id from users where name= :name", nativeQuery = true)
    String getUserId(@Param("name") String name);

//    @Query("select u from ")
//    void find();
}
