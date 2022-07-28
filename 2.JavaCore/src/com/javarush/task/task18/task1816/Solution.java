package com.javarush.task.task18.task1816;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String name = args[0];

        FileReader fr = new FileReader(name);

        int count = 0;

        while (fr.ready())
        {
            int data = fr.read();

            if(data >= 65 && data <= 90  ||  data >= 97 && data <= 122)
                ++count;
        }
        fr.close();

        System.out.println(count);
    }
}
