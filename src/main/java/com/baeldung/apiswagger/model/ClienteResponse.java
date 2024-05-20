package com.baeldung.apiswagger.model;

public class ClienteResponse {
    private String nome;
    private String cpf;
    private int quantidadeCompras;
    private double valorTotalCompras;

    public ClienteResponse(String nome, String cpf, int quantidadeCompras, double valorTotalCompras) {
        this.nome = nome;
        this.cpf = cpf;
        this.quantidadeCompras = quantidadeCompras;
        this.valorTotalCompras = valorTotalCompras;
    }

    // Getters e Setters

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

    public int getQuantidadeCompras() {
        return quantidadeCompras;
    }

    public void setQuantidadeCompras(int quantidadeCompras) {
        this.quantidadeCompras = quantidadeCompras;
    }

    public double getValorTotalCompras() {
        return valorTotalCompras;
    }

    public void setValorTotalCompras(double valorTotalCompras) {
        this.valorTotalCompras = valorTotalCompras;
    }
}