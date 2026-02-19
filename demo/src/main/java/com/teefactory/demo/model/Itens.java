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

    public Itens(Produto produto, Compra compra, Double precoUnitario) {
        this.produto = produto;
        this.compra = compra;
        this.precoUnitario = precoUnitario;
    }

    public Itens(Produto produto, Compra compra, Double precoUnitario, Integer quantidade) {
        this.produto = produto;
        this.compra = compra;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        result = prime * result + ((compra == null) ? 0 : compra.hashCode());
        result = prime * result + ((precoUnitario == null) ? 0 : precoUnitario.hashCode());
        result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Itens other = (Itens) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        if (compra == null) {
            if (other.compra != null)
                return false;
        } else if (!compra.equals(other.compra))
            return false;
        if (precoUnitario == null) {
            if (other.precoUnitario != null)
                return false;
        } else if (!precoUnitario.equals(other.precoUnitario))
            return false;
        if (quantidade == null) {
            if (other.quantidade != null)
                return false;
        } else if (!quantidade.equals(other.quantidade))
            return false;
        return true;
    }

}
