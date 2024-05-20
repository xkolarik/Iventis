package com.baeldung.apiswagger.api.controller;

import com.baeldung.apiswagger.exception.CompraNotFoundException;
import com.baeldung.apiswagger.model.ClienteResponse;
import com.baeldung.apiswagger.model.Compra;
import com.baeldung.apiswagger.model.CompraResponse;
import com.baeldung.apiswagger.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/")
    public List<Compra> getCompras() {
        return compraService.obterComprasOrdenadasPorValor();
    }

    @GetMapping("/maior-compra/{ano}")
    public CompraResponse getMaiorCompra(@PathVariable int ano) {
        Optional<CompraResponse> maiorCompra = compraService.getMaiorCompraDoAno(ano);

        return maiorCompra.orElseThrow(() -> new CompraNotFoundException("Nenhuma compra encontrada para o ano especificado"));
    }

    @GetMapping("/clientes-fieis")
    public List<ClienteResponse> getClientesFieis() {
        return compraService.obterTopClientesFieis(3);
    }

    @GetMapping("/recomendacao/cliente/{cpf}/tipo")
    public String recomendarVinhoPorTipo(@PathVariable String cpf) {
        return compraService.recomendarVinhoPorTipo(cpf);
    }
}