package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration5bis {

    @Test
    void registerFruitCartTestCase5bis_1() {

        Main machine = new Main();

        final String results = machine.registerFruitCart("Mele, Apples, Apples, Pommes, Apples, Mele, Cerises, Cerises, Bananes");

        assertEquals(String.valueOf(680), results);

    }

    @Test
    void registerFruitCartTestCase5bis_2() {

        Main machine = new Main();

        machine.registerFruitCart("Cerises, Apples");
        machine.registerFruitCart("Cerises");
        machine.registerFruitCart("Apples, Pommes, Bananes");
        machine.registerFruitCart("Apples, Pommes");
        machine.registerFruitCart("Mele");
        final String results = machine.registerFruitCart("Pommes");

        assertEquals(String.valueOf(880), results);

    }

}