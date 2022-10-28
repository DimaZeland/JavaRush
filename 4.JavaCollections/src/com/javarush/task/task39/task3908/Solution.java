package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

public class Solution
{
    public static void main(String[] args)
    {
        //System.out.println(isPalindromePermutation("dddaab"));
    }

    /*public static boolean isPalindromePermutation(String s)
    {
        if (s.length() % 2 == 0) return false;

        ArrayList<Character> list = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        for (int numberSingleCharacters = 0; list.size() > 0; )
        {
            Character c = list.remove(0);

            if (list.contains(c))
            {
                list.remove(c);
            } else
            {
                ++numberSingleCharacters;

                if (numberSingleCharacters > 1)
                    return false;
            }
        }
        return true;
    }*/

    public static boolean isPalindromePermutation(String s) {
        boolean foundOdd = false;
        int[] tableCount = new int[256];

        for (char c : s.toLowerCase().toCharArray()) {
            tableCount[c] += 1;
        }

        for (int count : tableCount) {
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }
}
