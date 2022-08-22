package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {

           /* if(0 == loadWheelNamesFromDB().length)
                throw new IllegalArgumentException();

            List<Wheel> wheels1 = new ArrayList<>();

            for(String string:loadWheelNamesFromDB())
                for (Wheel wheel:Wheel.values())
                {
                    if (string.equals(wheel.toString()))
                    {
                        wheels1.add(Wheel.valueOf(string));
                        break;
                    }
                    throw new IllegalArgumentException();
                }

            wheels = new ArrayList<>(wheels1);
            wheels1.clear();
            wheels1 = null;*/

            Set<Wheel> wheelSet = new HashSet<>(4);
            String[] wheelNamesFromDb = loadWheelNamesFromDB();
            if (wheelNamesFromDb.length != 4) throw new IllegalArgumentException();
            for (String wheelName : wheelNamesFromDb) {
                wheelSet.add(Wheel.valueOf(wheelName));
            }
            if (wheelSet.size() != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>(wheelSet);

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
