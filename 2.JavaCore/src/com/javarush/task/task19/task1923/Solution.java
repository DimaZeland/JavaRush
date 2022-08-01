package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String line = "";
        while (null != (line = bufferedReader.readLine()))
        {
            String[] words = line.split(" ");

            for (String word : words)
                if (word.matches(".*[0-9].*"))
                    bufferedWriter.write(word + " ");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
