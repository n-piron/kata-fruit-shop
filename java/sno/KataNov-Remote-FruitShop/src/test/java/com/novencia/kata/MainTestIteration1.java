package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTestIteration1 {

    @Test
    void registerFruitCartTestCase1() {

        Main machine = new Main();

        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Cerises");
        final String results = machine.registerFruitCart("Cerises");

        assertEquals(String.valueOf(250), results);
    }

    @Test
    void registerFruitCartTestCase1_2() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Bananes");
        final String results = machine.registerFruitCart("Pommes");

        assertEquals(String.valueOf(500), results);
    }
}