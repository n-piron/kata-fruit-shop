package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration3 {

    @Test
    void registerFruitCartTestCase3_1() {

        Main machine = new Main();


        machine.registerFruitCart("Pommes, Cerises, Bananes");
        final String results = machine.registerFruitCart("Pommes");

        assertEquals(String.valueOf(425), results);
    }


}