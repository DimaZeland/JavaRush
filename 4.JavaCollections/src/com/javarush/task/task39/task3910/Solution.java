package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {

        while (n > 2)
        {
            if (n % 3 != 0)
                return false;

            n = n / 3;
        }
        return 1 == n ? true : false;



        /*if (n % 3 == 0) {
            return true;
        }
        return false;*/
    }
}
