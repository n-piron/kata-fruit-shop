package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration3bis {

    @Test
    void registerFruitCartTestCase3bis_1() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Bananes");
        final String results = machine.registerFruitCart("Bananes");

        assertEquals(String.valueOf(270), results);

    }


    @Test
    void registerFruitCartTestCase3bis_2() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Bananes");
        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Bananes");
        final String results = machine.registerFruitCart("Cerises");

        assertEquals(String.valueOf(545), results);

    }


}