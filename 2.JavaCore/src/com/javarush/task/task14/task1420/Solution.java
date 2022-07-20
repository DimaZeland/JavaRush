package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            int one =Math.abs(Integer.valueOf(bufferedReader.readLine()));
            int two = Math.abs(Integer.valueOf(bufferedReader.readLine()));

            int res = gcdByBruteForce(one, two);
            System.out.println(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static int gcdByBruteForce(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
