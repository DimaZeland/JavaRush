package com.javarush.task.task29.task2909.human;

public class BloodGroup {
    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    static public BloodGroup first() {
        return new BloodGroup(1);
    }

    static public BloodGroup second() {
        return new BloodGroup(2);
    }

    static public BloodGroup third() {
        return new BloodGroup(3);
    }

    static public BloodGroup fourth() {
        return new BloodGroup(4);
    }
}
