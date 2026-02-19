package com.teefactory.demo.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teefactory.demo.dto.CompraDTO;
import com.teefactory.demo.model.Compra;
import com.teefactory.demo.model.Itens;
import com.teefactory.demo.model.Pessoa;
import com.teefactory.demo.model.Produto;
import com.teefactory.demo.repositories.CompraRepository;
import com.teefactory.demo.repositories.ItensRepository;
import com.teefactory.demo.repositories.PessoaRepository;
import com.teefactory.demo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ItensRepository itensRepository;

    @GetMapping("/add")
    public ModelAndView addCompra() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        ModelAndView mv = new ModelAndView("add-compra");
        mv.addObject("pessoas", pessoas);
        List<Produto> produtos = produtoRepository.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @PostMapping("/add")
    public String addCompraPost(@ModelAttribute CompraDTO compraDTO, RedirectAttributes ra) {
        Pessoa pessoa = pessoaRepository.findById(compraDTO.getPessoaId()).orElseThrow();
        Map<Produto, Integer> mapProdutos = new HashMap<>();
        LocalDateTime data = LocalDateTime.now();
        Double valorTotal = 0.0;
        List<Produto> produtos = new ArrayList<>();
        for (Integer i : compraDTO.getProdutosIds()) {
            Produto prod = produtoRepository.findById(i).orElseThrow();
            valorTotal += prod.getValor();
            produtos.add(prod);
            mapProdutos.put(prod, mapProdutos.getOrDefault(prod, 0) + 1);
        }
        Compra compra = new Compra(data, valorTotal, "Cartao", pessoa);
        compraRepository.save(compra);
        List<Itens> itens = new ArrayList<>();
        for (Map.Entry<Produto, Integer> entry : mapProdutos.entrySet()) {
            Produto prod = entry.getKey();
            Itens item = new Itens(prod, compra, prod.getValor(), entry.getValue());
            itens.add(item);
        }

        for (Itens i : itens) {
            itensRepository.save(i);
            System.out.println(i.getProduto().getNome());
        }

        ra.addFlashAttribute("successMessage", "Compra registrada com sucesso");
        return "redirect:/compra/add";

    }
}
