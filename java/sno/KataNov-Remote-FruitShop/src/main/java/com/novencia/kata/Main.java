package com.novencia.kata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static final int CERISE_REDUCTION = 20;

    private int SUM = 0;
    private List<String> cerisesInChart = new ArrayList<>();
    private List<String> bananesInChart = new ArrayList<>();
    private List<String> applesInChart = new ArrayList<>();
    private List<String> meleInChart = new ArrayList<>();
    private List<String> intInChart = new ArrayList<>();
    private List<String> totalFruit = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to FruitShop Kata");

    }

    public String registerFruitCart(String fruit) {

        LOGGER.debug("adding [" + fruit + "] to value that is [" + String.valueOf(Integer.valueOf(SUM)) + "]");
        String resultOneFruit = "NotInit";
        if (fruit.contains(",")) {

            String[] allFruits = fruit.split(",");
            for (String currentFruit : allFruits) {
                resultOneFruit = registerOneFruit(currentFruit.trim());
            }
        } else {
            resultOneFruit = registerOneFruit(fruit);
        }

        /*resultOneFruit = registerOneFruit(fruit);*/
        System.out.println("> "+ fruit +" -> " + resultOneFruit);
        return resultOneFruit;
    }

    private String registerOneFruit(String fruit) {

        totalFruit.add(fruit);

        LOGGER.debug("adding one fruit [" + fruit + "] to value that is [" + String.valueOf(Integer.valueOf(SUM)) + "]");
        switch (fruit) {
            case "Pommes" : SUM = SUM + 100; intInChart.add(fruit); break;
            case "Apples" : SUM = SUM + 100; applesInChart.add(fruit); intInChart.add(fruit); break;
            case "Mele" : SUM = SUM + 100; meleInChart.add(fruit); intInChart.add(fruit); break;

            case "Cerises" : SUM = SUM + 75; cerisesInChart.add(fruit); break;
            case "Bananes" : SUM = SUM + 150; bananesInChart.add(fruit); break;
        }

        final int cerisesNb = Collections.frequency(cerisesInChart, "Cerises");
        if (cerisesNb != 0 && cerisesNb % 2 == 0) {
            SUM = SUM - CERISE_REDUCTION;
            //because apply reduction once
            cerisesInChart = new ArrayList<>();
        }

        final int bananesNb = Collections.frequency(bananesInChart, "Bananes");
        if (bananesNb != 0 && bananesNb % 2 == 0) {
            SUM = SUM - 150;
            //because apply reduction once
            bananesInChart = new ArrayList<>();
        }

        final int applesNb = Collections.frequency(applesInChart, "Apples");
        if (applesNb != 0 && applesNb % 3 == 0) {
            SUM = SUM - 100;
            //because apply reduction once
            applesInChart = new ArrayList<>();
        }

        final int meleNb = Collections.frequency(meleInChart, "Mele");
        if (meleNb != 0 && meleNb % 2 == 0) {
            SUM = SUM - 100;
            //because apply reduction once
            meleInChart = new ArrayList<>();
        }

        int pommesNb = Collections.frequency(intInChart, "Mele");
        pommesNb = pommesNb + Collections.frequency(intInChart, "Pommes");
        pommesNb = pommesNb + Collections.frequency(intInChart, "Apples");
        if (pommesNb != 0 && pommesNb % 4 == 0) {
            SUM = SUM - 100;
            //because apply reduction once
            intInChart = new ArrayList<>();
        }

        final int modulo = totalFruit.size() % 5;
        LOGGER.debug("totalFruit.size() [" + modulo + "]");
        if (modulo == 0) {
            SUM = SUM - 200;
        }
        /*if (totalFruit.size() == 5) {
            SUM = SUM - 200;
        }*/

        LOGGER.debug("added [" + fruit + "] and value is [" + String.valueOf(Integer.valueOf(SUM)) + "]");
        return String.valueOf(Integer.valueOf(SUM));
    }

}
