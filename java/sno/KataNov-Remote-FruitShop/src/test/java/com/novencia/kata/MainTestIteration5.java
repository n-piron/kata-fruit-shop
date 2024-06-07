package com.novencia.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTestIteration5 {

    @Test
    void registerFruitCartTestCase5() {

        Main machine = new Main();

        machine.registerFruitCart("Mele");
        machine.registerFruitCart("Apples");
        machine.registerFruitCart("Apples");
        machine.registerFruitCart("Pommes");
        machine.registerFruitCart("Apples");
        machine.registerFruitCart("Mele");
        machine.registerFruitCart("Cerises");
        final String results = machine.registerFruitCart("Cerises");

        assertEquals(String.valueOf(580), results);

    }

}