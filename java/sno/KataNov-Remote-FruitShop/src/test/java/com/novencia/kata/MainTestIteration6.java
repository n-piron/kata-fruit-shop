package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration6 {

    @Test
    void registerFruitCartTestCase6_1() {

        Main machine = new Main();

        machine.registerFruitCart("Mele, Apples, Apples, Mele");
        machine.registerFruitCart("Bananes");
        final String results = machine.registerFruitCart("Mele, Apples, Apples, Pommes, Mele");

        assertEquals(String.valueOf(150), results);

    }

    @Test
    void registerFruitCartTestCase6_2() {

        Main machine = new Main();

        machine.registerFruitCart("Mele, Apples, Apples, Pommes, Mele");
        final String results = machine.registerFruitCart("Bananes");

        assertEquals(String.valueOf(250), results);

    }

}