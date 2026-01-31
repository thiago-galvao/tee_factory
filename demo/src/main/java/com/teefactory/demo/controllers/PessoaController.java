package com.teefactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teefactory.demo.model.Pessoa;
import com.teefactory.demo.repositories.PessoaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;


    public PessoaController(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository; 
    }

    @GetMapping("/add")
    public String pessoaSalva(){
        return "pessoa-add"; 
    }
    @PostMapping("/add")
    public String salvarPessoa(@RequestParam String nome, @RequestParam String email, RedirectAttributes redirectAttributes){
        Pessoa p = new Pessoa(nome, email); 
        Pessoa teste = pessoaRepository.save(p); 
        redirectAttributes.addFlashAttribute("successMessage", "Pessoa salva com sucesso!");
        return "redirect:/pessoa/add"; 
    }


}
