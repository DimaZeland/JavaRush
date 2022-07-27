package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        FileInputStream fi = new FileInputStream(s);

        final int code = ',';
        int count = 0;

        while (fi.available() > 0)
            if (code == fi.read())
                ++count;

        fi.close();

        System.out.println(count);
    }
}
