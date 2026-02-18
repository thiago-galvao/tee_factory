package com.teefactory.demo.dto;

import java.util.List;

import com.teefactory.demo.model.Compra;
import com.teefactory.demo.model.Itens;
import com.teefactory.demo.model.Pessoa;
import com.teefactory.demo.model.Produto;

public class CompraDTO {

    private Integer pessoaId;
    private List<Integer> produtosIds;

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public List<Integer> getProdutosIds() {
        return produtosIds;
    }

    public void setProdutosIds(List<Integer> produtosIds) {
        this.produtosIds = produtosIds;
    }

}
