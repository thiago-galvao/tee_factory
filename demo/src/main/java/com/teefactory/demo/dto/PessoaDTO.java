package com.teefactory.demo.dto;

public class PessoaDTO {

    private String nome;
    private String email;
    private String rua;
    private int numero;
    private String bairro;

    public PessoaDTO(String nome, String email, String rua, int numero, String bairro) {
        this.nome = nome;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
