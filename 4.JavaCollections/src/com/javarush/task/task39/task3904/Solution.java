package com.javarush.task.task39.task3904;

/*
Лестница
*/

public class Solution
{
    private static int n = 70;

    public static void main(String[] args)
    {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;

        long a = 1, b = 1, c = 2;

        long sum = 0;

        for(int i = 3; i <= n;++i)
        {
            // a b c sum
            // 1 1 2 4
            //   a b c sum
            //   1 2 4 7

            sum = a + b + c; // 4

            a = b;
            b = c;
            c = sum;
        }
        return sum;
    }
}

