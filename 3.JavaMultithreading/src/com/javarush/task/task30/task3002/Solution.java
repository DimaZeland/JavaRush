package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        String digit = "";
        int numberSystem = 0;

        if (s.startsWith("0x")) {
            digit = s.substring(2, s.length());
            numberSystem = 16;
        } else if (s.startsWith("0b")) {
            digit = s.substring(2, s.length());
            numberSystem = 2;
        } else if (s.startsWith("0")) {
            digit = s.substring(1, s.length());
            numberSystem = 8;
        } else {
            digit = s;
            numberSystem = 10;
        }

        int decimalValue = Integer.parseInt(digit, numberSystem);

        return String.valueOf(decimalValue);

        //return convertToDecimal(digit, numberSystem);
    }

    public static String convertToDecimal(String digit, int numberSystem) {
        long decimalValue = 0;

        // convert to decimal
        for (int degree = digit.length() - 1, charIndex = 0; degree >= 0; degree--, charIndex++) {
            char ch = digit.charAt(charIndex);
            int numeral = (int) ch > 96 ? (int) ch - 87 : Character.getNumericValue(ch); // 'a' has ANSI code 97

            if (numeral >= numberSystem)
                throw new NumberFormatException();

            decimalValue += numeral * Math.pow(numberSystem, degree);
        }
        return String.valueOf(decimalValue);
    }
}
