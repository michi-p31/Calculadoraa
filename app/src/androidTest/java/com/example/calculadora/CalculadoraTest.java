package com.example.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class  CalculadoraTest {

    private MainActivity.Calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new MainActivity.Calculadora();
    }

    @Test
    public void sumaCorrecta() {
        String expresion = "2+2";
        String resultadoEsperado = "4";
        String resultadoObtenido = calculadora.getResult(expresion);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void restaCorrecta() {
        String expresion = "5-3";
        String resultadoEsperado = "2";
        String resultadoObtenido = calculadora.getResult(expresion);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void multiplicacionCorrecta() {
        String expresion = "2*4";
        String resultadoEsperado = "8";
        String resultadoObtenido = calculadora.getResult(expresion);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void divisionCorrecta() {
        String expresion = "10/2";
        String resultadoEsperado = "5";
        String resultadoObtenido = calculadora.getResult(expresion);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testCalcularFactorial() {
        int resultadoEsperado = 120;
        int resultadoObtenido = MainActivity.calcularfactorial(5);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testCalcularFibonacci() {
        int resultadoEsperado = 1;
        int resultadoObtenido = MainActivity.calcularfibonaci(1);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}