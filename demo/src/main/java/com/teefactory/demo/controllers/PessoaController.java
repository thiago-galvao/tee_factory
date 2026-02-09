package com.teefactory.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teefactory.demo.dto.PessoaDTO;
import com.teefactory.demo.model.Endereco;
import com.teefactory.demo.model.Pessoa;
import com.teefactory.demo.repositories.PessoaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/add")
    public String pessoaSalva() {
        return "pessoa-add";
    }

    @PostMapping("/add")
    public String salvarPessoa(@RequestParam String nome, @RequestParam String email, @RequestParam String rua,
            @RequestParam Integer numero, @RequestParam String bairro, RedirectAttributes redirectAttributes) {
        Pessoa p = new Pessoa(nome, email);
        Endereco e = new Endereco(rua,numero,bairro); 
        p.getEnderecos().add(e); 
        pessoaRepository.save(p); 
        redirectAttributes.addFlashAttribute("successMessage", "Pessoa salva com sucesso!");
        return "redirect:/pessoa/add";
    }

    @GetMapping("/list")
    public ModelAndView nomes() {
        List<String> nomes = pessoaRepository.buscarNomes();
        ModelAndView mv = new ModelAndView("pessoa-list");
        mv.addObject("nome", nomes);
        return mv;
    }
    
    @GetMapping("/endereco")
    public ModelAndView pessoas(){
        List<PessoaDTO> pessoas = pessoaRepository.pessoas(); 
        ModelAndView mv = new ModelAndView("pessoa-endereco"); 
        mv.addObject("pessoas", pessoas); 
        return mv; 
    }

}
