package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1990, 5, 18);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String result = null;
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                result = "воскресенье";
                break;
            case Calendar.MONDAY:
                result = "понедельник";
                break;
            case Calendar.TUESDAY:
                result = "вторник";
                break;
            case Calendar.WEDNESDAY:
                result = "среда";
                break;
            case Calendar.THURSDAY:
                result = "четверг";
                break;
            case Calendar.FRIDAY:
                result = "пятница";
                break;
            case Calendar.SATURDAY:
                result = "суббота";
                break;
            default:
                result = "ошибка";
        }
        ;

        return result;
    }
}
