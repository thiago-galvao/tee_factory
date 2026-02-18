package com.teefactory.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tee_itens")
public class Itens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @Column(name = "preco_unitario", nullable = false)
    private Double precoUnitario;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Itens(Integer id, Produto produto, Compra compra, Double precoUnitario, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.compra = compra;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public Itens(Produto produto, Compra compra, Double precoUnitario, Integer quantidade) {
        this.produto = produto;
        this.compra = compra;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }
    

}
