package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration2 {

    @Test
    void registerFruitCartTestCase2_1() {

        Main machine = new Main();

        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Cerises");
        final String results = machine.registerFruitCart("Cerises");

        assertEquals(String.valueOf(230), results);
    }

    @Test
    void registerFruitCartTestCase2_2() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Bananes");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Cerises");
        final String results = machine.registerFruitCart("Pommes");

        assertEquals(String.valueOf(610), results);
    }
}