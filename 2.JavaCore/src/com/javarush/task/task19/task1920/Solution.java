package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Boolean tested = false;

        String fileName = tested ? "D:\\1.txt" : args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = "";

        TreeMap<String, Double> data = new TreeMap<>();

        while (null != (line = bufferedReader.readLine())) {
            String[] lineValues = line.split(" ");
            String key = lineValues[0];
            Double newValue = Double.parseDouble(lineValues[1]);

            Double oldValue = null == data.get(key) ? .0 : data.get(key);

            data.put(key, oldValue + newValue);
        }

        bufferedReader.close();

        final double[] maxValue = {.0};

        data.entrySet().forEach(x -> {
            if (x.getValue() > maxValue[0]) maxValue[0] = x.getValue();
        });

        TreeMap<String, Double> maxData = new TreeMap<>();

        data.entrySet().forEach(x -> {
            if (x.getValue() == maxValue[0]) maxData.put(x.getKey(), x.getValue());
        });

        for (String key : maxData.keySet())
            System.out.println(key);

        //maxData.entrySet().forEach(System.out::println);
    }
}
