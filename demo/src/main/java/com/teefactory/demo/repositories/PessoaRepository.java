package com.teefactory.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teefactory.demo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
    @Query("select p.nome from Pessoa p")
    List<String> buscarNomes(); 
}
