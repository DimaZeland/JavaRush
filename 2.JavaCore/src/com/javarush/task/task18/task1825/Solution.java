package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/* 
Собираем файл
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";
        List<String> names = new ArrayList<>();
        while (!"end".equals(fileName = bufferedReader.readLine()))
        {
            names.add(fileName);
        }
        bufferedReader.close();

        Collections.sort(names);

        String firstPart = names.get(0);
        int partEndIndex = names.get(0).lastIndexOf(".part");
        String fileWrite = firstPart.substring(0, partEndIndex);
        BufferedWriter fo = new BufferedWriter(new FileWriter(fileWrite));

        for (String fileName1 : names)
        {
            bufferedReader = new BufferedReader(new FileReader(fileName1));

            while (bufferedReader.ready())
                fo.write(bufferedReader.read());

            bufferedReader.close();
        }
        fo.close();

    }
}
