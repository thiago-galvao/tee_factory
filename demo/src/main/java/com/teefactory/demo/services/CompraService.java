package com.teefactory.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teefactory.demo.repositories.CompraRepository;
import com.teefactory.demo.repositories.ItensRepository;
import com.teefactory.demo.repositories.PessoaRepository;

@Service
public class CompraService {
    

    @Autowired
    private CompraRepository compraRepository; 

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ItensRepository itensRepository; 

    
}
