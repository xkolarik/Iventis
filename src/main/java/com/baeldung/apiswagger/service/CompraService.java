package com.baeldung.apiswagger.service;

import com.baeldung.apiswagger.model.ClienteResponse;
import com.baeldung.apiswagger.model.Compra;
import com.baeldung.apiswagger.model.CompraResponse;

import java.util.List;
import java.util.Optional;

public interface CompraService {
    public List<Compra> obterComprasOrdenadasPorValor();

    Optional<CompraResponse> getMaiorCompraDoAno(int year);

    List<ClienteResponse> obterTopClientesFieis(int i);

    String recomendarVinhoPorTipo(String cpf);
}