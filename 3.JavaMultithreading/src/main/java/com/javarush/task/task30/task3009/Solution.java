package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        try {
            int numberToProcess = Integer.parseInt(number);
            for (int i = 2; i <= 36; i++) {
                String temp = Integer.toString(numberToProcess, i);
                if (isPalindrom(temp)) {
                    result.add(i);
                }
            }
        } catch (NumberFormatException e) {
        }
        return result;
    }

    private static boolean isPalindrom(String number) {
        return number.equals((new StringBuilder(number)).reverse().toString());
    }

    /*private static Set<Integer> getRadix(String number)
    {
        HashSet<Integer> result = new HashSet<>();
        String convertNumber = "";
        try
        {
            for (int i = 2; i < 37; i++)
            {
                convertNumber = convertDecimalToOtherNumberSystem(number, i);
                boolean isPalindrom = true;
                for (int j = 0, k = convertNumber.length() - 1; k > j; j++, k--)
                {
                    if (convertNumber.charAt(j) != convertNumber.charAt(k))
                    {
                        isPalindrom = false;
                        break;
                    }
                }
                if (isPalindrom)
                    result.add(i);
            }
        } catch (NumberFormatException e)
        {
        } finally
        {
            return result;
        }
    }

    public static String convertDecimalToOtherNumberSystem(String number, int numberSystem) throws NumberFormatException
    {
        long decimalValue = 0;
        decimalValue = Long.valueOf(number);
        StringBuilder expectedValue = new StringBuilder();

        while (true)
        {
            int numeral = (int) (decimalValue % numberSystem);

            char ch = numberSystem > 10 ? (char) (numeral + 87) : Character.forDigit(numeral, 10);

            expectedValue.insert(0, ch);
            decimalValue /= numberSystem;

            if (decimalValue < numberSystem)
            {
                ch = numberSystem > 10 ? (char) (decimalValue + 87) : Character.forDigit((int) decimalValue, 10);
                expectedValue.insert(0, ch);
                break;
            }
        }
        return expectedValue.toString();
    }*/
}