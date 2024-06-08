package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration4 {

    @Test
    void registerFruitCartTestCase4_1() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Apples");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Bananes");
        final String results = machine.registerFruitCart("Bananes");

        assertEquals(String.valueOf(380), results);

    }

    @Test
    void registerFruitCartTestCase4_2() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Apples");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Bananes");
        machine.registerFruitCart("Pommes");
        final String results = machine.registerFruitCart("Mele");

        assertEquals(String.valueOf(580), results);

    }


}