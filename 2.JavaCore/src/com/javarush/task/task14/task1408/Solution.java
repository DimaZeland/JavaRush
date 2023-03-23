package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import static com.javarush.task.task14.task1408.Country.*;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;

            switch (country) {
                case RUSSIA:
                    hen = new RussianHen();
                    break;
                case UKRAINE:
                    hen = new UkrainianHen();
                    break;
                case MOLDOVA:
                    hen = new MoldovanHen();
                    break;
                case BELARUS:
                    hen = new BelarusianHen();
                    break;
            }

            return hen;
        }
    }


}

abstract class Hen {
    public abstract int getCountOfEggsPerMonth();

    public String getDescription() {
        return "Я - курица.";
    }
}




