package com.teefactory.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teefactory.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
