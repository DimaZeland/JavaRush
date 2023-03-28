package com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private static Moon instance;

    private Moon() {
    }

    public static Moon getInstance() {
        if (null == instance)
            instance = new Moon();

        return instance;
    }
}
