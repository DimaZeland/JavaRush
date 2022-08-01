package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    private static final boolean tested = false;
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }

    public static void main(String[] args) {
        String file1 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = tested ? "D:\\1.txt" : reader.readLine();

        } catch (IOException ignore) {
            /* NOP */
        }

        String fileLine;

        try (BufferedReader in = new BufferedReader(new FileReader(file1))) {
            while ((fileLine = in.readLine()) != null) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(fileLine);
            }
        } catch (IOException ignore) {
            /* NOP */
        }


    }
}
