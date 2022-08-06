package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        //return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;
               //a1  b1   c1   d0                   a0   c1      b0    c1    c1    d1
    }

    public static void main(String[] args) {

    }
}
