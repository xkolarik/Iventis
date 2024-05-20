package com.baeldung.apiswagger.client;

import com.baeldung.apiswagger.config.SwaggerConfiguration;
import com.baeldung.apiswagger.model.Cliente;
import com.baeldung.apiswagger.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "DadosApiClient", url = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com", configuration = SwaggerConfiguration.class)
public interface DadosApiClient {

    @GetMapping("/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json")
    List<Produto> getProdutos();

    @GetMapping("/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json")
    List<Cliente> getClientes();
}
