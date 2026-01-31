package com.teefactory.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teefactory.demo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
    
}
