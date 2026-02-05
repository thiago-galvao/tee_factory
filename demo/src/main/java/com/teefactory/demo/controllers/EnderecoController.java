package com.teefactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teefactory.demo.model.Endereco;
import com.teefactory.demo.repositories.EnderecoRepository;
import com.teefactory.demo.repositories.PessoaRepository;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoRepository enderecoRepository; 

    @Autowired 
    private PessoaRepository pessoaRepository; 

    // @GetMapping("/add")
    // public ModelAndView add(@RequestParam String rua, @RequestParam Integer numero, @RequestParam String bairro, RedirectAttributes redirectAttributes){
    //     ModelAndView mv = new ModelAndView("endereco-add"); 
    //     Endereco e = new Endereco(rua, numero, bairro); 

    // }
}
