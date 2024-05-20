package com.baeldung.apiswagger.model;

public class CompraResponse {

    private String clienteNome;
    private String clienteCpf;
    private String produtoNome;
    private int quantidade;
    private double valorTotal;

    public CompraResponse(String clienteNome, String clienteCpf, String produtoNome, int quantidade, double valorTotal) {
        this.clienteNome = clienteNome;
        this.clienteCpf = clienteCpf;
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
