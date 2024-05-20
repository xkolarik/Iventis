package com.baeldung.apiswagger.service.impl;

import com.baeldung.apiswagger.client.DadosApiClient;
import com.baeldung.apiswagger.model.*;
import com.baeldung.apiswagger.service.CompraService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public record CompraServiceImpl(DadosApiClient dadosApiClient) implements CompraService {

    private static List<Produto> produtos = null;
    private static List<Cliente> clientes = null;

    public CompraServiceImpl(DadosApiClient dadosApiClient) {
        this.dadosApiClient = dadosApiClient;
        produtos = dadosApiClient.getProdutos();
        clientes = dadosApiClient.getClientes();
    }

    @Override
    public List<Compra> obterComprasOrdenadasPorValor() {
        List<Compra> todasCompras = clientes.stream()
                .flatMap(cliente -> cliente.getCompras().stream())
                .toList();

        todasCompras.forEach(compra -> {
            Produto produto = encontrarProdutoPorCodigo(compra.getCodigo());
            if (produto != null) {
                compra.setProduto(produto);
                double valorTotal = produto.getPreco() * compra.getQuantidade();
                compra.setValorTotal(valorTotal);
            }
        });

        return todasCompras.stream()
                .sorted(Comparator.comparingDouble(Compra::getValorTotal))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CompraResponse> getMaiorCompraDoAno(int ano) {
        return clientes.stream()
                .flatMap(cliente -> cliente.getCompras().stream()
                        .map(compra -> {
                            Produto produto = encontrarProdutoPorCodigoEAno(compra.getCodigo(), ano);
                            if (produto != null) {
                                double valorTotal = produto.getPreco() * compra.getQuantidade();
                                return new CompraResponse(cliente.getNome(), cliente.getCpf(), produto.getTipo_vinho(), compra.getQuantidade(), valorTotal);
                            }
                            return null;
                        })
                        .filter(Objects::nonNull))
                .max(Comparator.comparingDouble(CompraResponse::getValorTotal));
    }

    @Override
    public List<ClienteResponse> obterTopClientesFieis(int limite) {
        return clientes.stream()
                .map(cliente -> {
                    double valorTotalCompras = calcularValorTotalCompras(cliente);
                    return new ClienteResponse(cliente.getNome(), cliente.getCpf(), cliente.getCompras().size(), valorTotalCompras);
                })
                .sorted(Comparator.comparing(ClienteResponse::getQuantidadeCompras).reversed()
                        .thenComparing(ClienteResponse::getValorTotalCompras).reversed())
                .limit(limite)
                .collect(Collectors.toList());
    }

    @Override
    public String recomendarVinhoPorTipo(String cpf) {
        Cliente cliente = encontrarClientePorCpf(cpf);

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Map<String, Integer> tiposComprados = contarTiposDeVinhoCompradosPeloCliente(cliente);

        String tipoRecomendado = tiposComprados.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        if (tipoRecomendado == null) {
            throw new RuntimeException("Nenhum tipo de vinho comprado pelo cliente");
        }

        return "Recomendação para o cliente: Compre mais vinho " + tipoRecomendado;
    }

    private Produto encontrarProdutoPorCodigo(int codigo) {
        return produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    private Produto encontrarProdutoPorCodigoEAno(int codigo, int ano) {
        return produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo) && p.getAno_compra() == ano)
                .findFirst()
                .orElse(null);
    }

    private Cliente encontrarClientePorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    private double calcularValorTotalCompras(Cliente cliente) {
        return cliente.getCompras().stream()
                .mapToDouble(compra -> {
                    Produto produto = encontrarProdutoPorCodigo(compra.getCodigo());
                    return (produto != null) ? produto.getPreco() * compra.getQuantidade() : 0;
                })
                .sum();
    }

    private Map<String, Integer> contarTiposDeVinhoCompradosPeloCliente(Cliente cliente) {
        Map<String, Integer> tiposComprados = new HashMap<>();
        cliente.getCompras().forEach(compra -> {
            Produto produto = encontrarProdutoPorCodigo(compra.getCodigo());
            if (produto != null) {
                tiposComprados.put(produto.getTipo_vinho(), tiposComprados.getOrDefault(produto.getTipo_vinho(), 0) + compra.getQuantidade());
            }
        });
        return tiposComprados;
    }
}