package com.teefactory.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teefactory.demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
}
