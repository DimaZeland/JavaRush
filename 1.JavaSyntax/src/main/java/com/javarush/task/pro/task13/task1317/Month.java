package com.javarush.task.pro.task13.task1317;

/* 
Трансформируем enum в класс
*/

public class Month {
    public static final com.javarush.task.pro.task13.task1317.Month JANUARY = new com.javarush.task.pro.task13.task1317.Month(0);
    public static final com.javarush.task.pro.task13.task1317.Month FEBRUARY = new com.javarush.task.pro.task13.task1317.Month(1);
    public static final com.javarush.task.pro.task13.task1317.Month MARCH = new com.javarush.task.pro.task13.task1317.Month(2);
    public static final com.javarush.task.pro.task13.task1317.Month APRIL = new com.javarush.task.pro.task13.task1317.Month(3);
    public static final com.javarush.task.pro.task13.task1317.Month MAY = new com.javarush.task.pro.task13.task1317.Month(4);
    public static final com.javarush.task.pro.task13.task1317.Month JUNE = new com.javarush.task.pro.task13.task1317.Month(5);
    public static final com.javarush.task.pro.task13.task1317.Month JULY = new com.javarush.task.pro.task13.task1317.Month(6);
    public static final com.javarush.task.pro.task13.task1317.Month AUGUST = new com.javarush.task.pro.task13.task1317.Month(7);
    public static final com.javarush.task.pro.task13.task1317.Month SEPTEMBER = new com.javarush.task.pro.task13.task1317.Month(8);
    public static final com.javarush.task.pro.task13.task1317.Month OCTOBER = new com.javarush.task.pro.task13.task1317.Month(9);
    public static final com.javarush.task.pro.task13.task1317.Month NOVEMBER = new com.javarush.task.pro.task13.task1317.Month(10);
    public static final com.javarush.task.pro.task13.task1317.Month DECEMBER = new com.javarush.task.pro.task13.task1317.Month(11);
    private static final com.javarush.task.pro.task13.task1317.Month[] VALUES = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};

    private final int value;

    private Month(int value) {
        this.value = value;
    }

    public int ordinal() {
        return value;
    }

    public static com.javarush.task.pro.task13.task1317.Month[] values() {
        return VALUES;
    }
}
