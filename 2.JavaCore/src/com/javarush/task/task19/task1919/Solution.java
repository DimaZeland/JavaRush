package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Boolean tested = false;

        String fileName = tested ? "D:\\1.txt" : args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = "";

        TreeMap<String, Double> data = new TreeMap<>();

        while (null != (line = bufferedReader.readLine()))
        {
            String[] lineValues = line.split(" ");
            String key = lineValues[0];
            Double newValue = Double.parseDouble(lineValues[1]);

            Double oldValue = null == data.get(key) ? .0 : data.get(key);

            data.put(key, oldValue + newValue);
        }

        bufferedReader.close();

        //data.entrySet().forEach(System.out::println);

        for (String key : data.keySet())
            System.out.println(key + " " + data.get(key));
    }
}
