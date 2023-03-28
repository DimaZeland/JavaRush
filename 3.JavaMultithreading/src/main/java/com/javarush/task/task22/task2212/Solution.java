package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;
        
        /*Pattern pattern = Pattern.compile("[+(0]{1}[(\\d]{1}[\\d]{1}[\\d(]{1}[\\d)]{1}[\\d)]{1}[\\d]{1}[\\d)]{1}[\\d]{4,7}");
        Matcher matcher = pattern.matcher(telNumber);

        return matcher.matches();*/
        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
    }

    public static void main(String[] args) {

    }
}
