package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        BitSet bs = BitSet.valueOf(new long[]{number});

        boolean bitIsSetAtIndexI = ((number >>> i) & 1) == 1 ? true : false;
        boolean bitIsSetAtIndexJ = ((number >>> j) & 1) == 1 ? true : false;

        bs.set(i, bitIsSetAtIndexJ);
        bs.set(j, bitIsSetAtIndexI);

        return bs.toLongArray()[0];
    }
}
