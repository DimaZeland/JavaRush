package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String name = /*"D:\\1.txt"*/args[0];
        File file = new File(name);
        FileReader reader = new FileReader(file);
        BufferedReader reader2 = new BufferedReader(reader);
        TreeSet<Character> characters = new TreeSet<Character>();

        int symb = 0;

        while ((symb = reader.read()) != -1)
        {
            int codePoint = Character.toLowerCase(symb);
            Character character = new Character((char) codePoint);
            if (Character.isLetter(character))
                characters.add(character);
        }

        for (int i = 0; i < 5 && characters.size() > 0; i++)
        {
            System.out.print(characters.pollFirst());
        }
    }
}
