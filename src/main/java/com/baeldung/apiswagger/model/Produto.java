package com.baeldung.apiswagger.model;

public class Produto {

    private Integer codigo;
    private String tipo_vinho;
    private double preco;
    private String safra;
    private Integer ano_compra;

    public Produto(Integer codigo, String tipo_vinho, double preco, String safra, Integer ano_compra) {
        this.codigo = codigo;
        this.tipo_vinho = tipo_vinho;
        this.preco = preco;
        this.safra = safra;
        this.ano_compra = ano_compra;

    }
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo_vinho() {
        return tipo_vinho;
    }

    public void setTipo_vinho(String tipo_vinho) {
        this.tipo_vinho = tipo_vinho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public Integer getAno_compra() {
        return ano_compra;
    }

    public void setAno_compra(Integer ano_compra) {
        this.ano_compra = ano_compra;
    }
}
