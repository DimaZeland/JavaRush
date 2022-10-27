package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if(s.length() == 0 || null == s)
            return 0;

        Set<Character> characters = new HashSet<>();

        int maxLength = 0;

        for (int i = 0, len = 0; i < s.length(); ++i, ++len)
        {
            Character ch = s.charAt(i);

            if(len > maxLength)
                maxLength = len;

            if(characters.contains(ch))
            {
                len = 0;
                characters.clear();
                characters.add(ch);
            }
            else
                characters.add(ch);


        }
        
        return maxLength;
    }
}
