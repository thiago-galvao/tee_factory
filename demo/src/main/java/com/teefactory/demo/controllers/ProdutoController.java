package com.teefactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teefactory.demo.model.Produto;
import com.teefactory.demo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/add")
    public String addProduto() {
        return "produto-add";
    }

    @PostMapping("/add")
    public String addProdutoPost(@RequestParam String nome, @RequestParam(required = false) String descricao,@RequestParam Double valor, RedirectAttributes ra) {
        Produto produto = new Produto(nome, descricao, valor);
        produtoRepository.save(produto);
        ra.addFlashAttribute("successMessage", "Produto salvo com sucesso");
        return "redirect:/produto/add";
    }

}
