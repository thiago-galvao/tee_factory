package com.teefactory.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teefactory.demo.repositories.EnderecoRepository;
import com.teefactory.demo.repositories.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository; 

    @Autowired
    private EnderecoRepository enderecoRepository; 

}
