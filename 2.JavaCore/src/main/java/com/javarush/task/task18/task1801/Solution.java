package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName);

        int n = 0;
        int max = Byte.MIN_VALUE;
        while (fi.available() > 0) {
            n = fi.read();

            if (max < n)
                max = n;
        }
        fi.close();

        System.out.println(max);
    }
}
