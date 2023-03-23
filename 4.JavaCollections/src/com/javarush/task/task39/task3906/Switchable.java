package com.javarush.task.task39.task3906;

public interface Switchable {
    void turnOff();

    void turnOn();

    default boolean isOn() {
        return true;
    }
}
