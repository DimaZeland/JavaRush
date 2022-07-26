package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName);

        int n = 0;
        int min = Byte.MAX_VALUE;
        while (fi.available() > 0)
        {
            n = fi.read();

            if(min > n)
                min = n;
        }
        fi.close();

        System.out.println(min);
    }
}
