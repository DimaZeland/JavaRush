package com.javarush.task.pro.task12.task1205;

/* 
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b)
    {
        Double result;

        if(a>0 && 0 == b
                ||Double.POSITIVE_INFINITY == a && b >= 0 && Double.POSITIVE_INFINITY != Double.POSITIVE_INFINITY
            || Double.NEGATIVE_INFINITY == a && b < 0 && Double.NEGATIVE_INFINITY != b)
         result = Double.POSITIVE_INFINITY;
        else if(0 > a && 0 == b
            || Double.NEGATIVE_INFINITY == a && b >= 0 && Double.POSITIVE_INFINITY != b
                || Double.POSITIVE_INFINITY == a && b < 0 && Double.NEGATIVE_INFINITY != b)
            result = Double.NEGATIVE_INFINITY;
        else if(0 == a && 0 == b
                || Double.NaN == a
                || Double.NaN == b
                || Double.POSITIVE_INFINITY == a && b == Double.POSITIVE_INFINITY
                || Double.POSITIVE_INFINITY == a && Double.NEGATIVE_INFINITY == b
                || Double.NEGATIVE_INFINITY == a && Double.POSITIVE_INFINITY == b
                || Double.NEGATIVE_INFINITY == a && Double.NEGATIVE_INFINITY == b)
            result = Double.NaN;
        else
            result = a / b;
        
        System.out.println(result);
    }
}
