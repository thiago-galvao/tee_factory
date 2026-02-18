package com.teefactory.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teefactory.demo.model.Compra;

public interface CompraRepository extends JpaRepository <Compra, Integer> {
    
}
