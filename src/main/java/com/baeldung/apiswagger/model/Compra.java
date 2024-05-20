package com.baeldung.apiswagger.model;

public class Compra {

    private Integer codigo;
    private Integer quantidade;
    private Produto produto;

    private double valorTotal;

    public Compra(Integer codigo, Integer quantidade, Produto produto, double valorTotal) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valorTotal = valorTotal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}