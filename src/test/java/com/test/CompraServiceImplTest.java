package com.test;

import com.baeldung.apiswagger.Application;
import com.baeldung.apiswagger.client.DadosApiClient;
import com.baeldung.apiswagger.model.Compra;
import com.baeldung.apiswagger.service.impl.CompraServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class CompraServiceImplTest {

    @Mock
    private DadosApiClient dadosApiClient;

    @Autowired
    @InjectMocks
    private CompraServiceImpl compraService;

    @Test
    public void obterComprasOrdenadasPorValorTest() {

        List<Compra> comprasOrdenadasMock = Arrays.asList(
                new Compra(1, 2, null, 0.0),
                new Compra(2, 1, null, 0.0),
        new Compra(1, 3, null, 0.0)
        );

        when(compraService.obterComprasOrdenadasPorValor()).thenReturn(comprasOrdenadasMock);

        compraService.obterComprasOrdenadasPorValor();

        // Verificar resultado
        assertEquals(3, comprasOrdenadasMock.size());
    }

    // Testes para os demais métodos aqui...

}