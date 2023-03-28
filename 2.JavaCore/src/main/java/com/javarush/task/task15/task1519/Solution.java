package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while (!"exit".equals((str = br.readLine()))) {
            if (str.contains(".")) {
                try {
                    print(Double.parseDouble(str));
                } catch (NullPointerException | NumberFormatException e) {
                    print(str);
                    //e.printStackTrace();
                }
            } else {
                try {
                    Integer val = Integer.valueOf(str);

                    if (val > 0 && val < 128)
                        print(val.shortValue());
                    else if (val <= 0 || val >= 128)
                        print(val);
                } catch (Exception e) {
                    // e.printStackTrace();
                    print(str);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
