package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution
{
    public static void main(String[] args)
    {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a)
    {
        final int length = a.length;

        int count = 0;

        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                if ((1 == a[i][j]) && (i + 1 == length || 0 == a[i + 1][j]) && (j + 1 == length || 0 == a[i][j + 1]))
                    ++count;

        return count;
    }
}







