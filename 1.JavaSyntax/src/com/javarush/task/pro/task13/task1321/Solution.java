package com.javarush.task.pro.task13.task1321;

import java.util.Locale;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getTranslationForDayOfWeek("Вторник"));
        System.out.println(getTranslationForDayOfWeek("Пятница"));
        System.out.println(getTranslationForDayOfWeek("Высплюсенье"));
    }

    public static String getTranslationForDayOfWeek(String ru) {
        String en;

        String ruIgnoreCase = ru.toLowerCase();

        if (ruIgnoreCase.equals("понедельник"))
            en = "Monday";
        else if (ruIgnoreCase.equals("вторник"))
            en = "Tuesday";
        else if (ruIgnoreCase.equals("среда"))
            en = "Wednesday";
        else if (ruIgnoreCase.equals("четверг"))
            en = "Thursday";
        else if (ruIgnoreCase.equals("пятница"))
            en = "Friday";
        else if (ruIgnoreCase.equals("суббота"))
            en = "Saturday";
        else if (ruIgnoreCase.equals("воскресенье"))
            en = "Sunday";
        else
            en = "Недействительный день недели";
        return en;

    }
}
