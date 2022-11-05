package com.brq.ms01.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* @ExtendWith é uma anotação para permitir a execução e regitro de testes unitários
* SpringExtension.class permite integração do Spring Boot com o Junit
*/
@ExtendWith(SpringExtension.class)
class CalculadoraUtilTests {
    private CalculadoraUtil calculadoraUtil = new CalculadoraUtil();

    @Test
    void somarTest(){
        int resultadoAtual = calculadoraUtil.somar(7,15);

        int resultadoEsperado = 22;

        assertEquals(resultadoEsperado, resultadoAtual);
    }
}