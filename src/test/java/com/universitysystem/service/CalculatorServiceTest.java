package com.universitysystem.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    void init() {
        calculatorService = new CalculatorService();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,7,9", "11,20,31"})
    void add(Integer a, Integer b, Integer c) {
        var result = calculatorService.add(a, b);

        assertEquals(c, result);
    }
}
