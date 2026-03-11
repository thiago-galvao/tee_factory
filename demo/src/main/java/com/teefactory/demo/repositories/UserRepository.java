package com.teefactory.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teefactory.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   public Optional<User> findByLogin(String login); 
}
