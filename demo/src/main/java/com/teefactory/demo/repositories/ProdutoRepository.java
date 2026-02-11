package com.teefactory.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teefactory.demo.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
