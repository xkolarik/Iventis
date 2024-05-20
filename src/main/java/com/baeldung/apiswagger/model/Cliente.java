package com.baeldung.apiswagger.model;

import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private List<Compra> compras;

    public Cliente(String nome, String cpf, List<Compra> compras) {
        this.nome = nome;
        this.cpf = cpf;
        this.compras = compras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}