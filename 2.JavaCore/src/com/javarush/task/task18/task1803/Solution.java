package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileInputStream fi = new FileInputStream(fileName);

        int[] arr = new int[256];

        while (fi.available() > 0)
            arr[fi.read()] += 1;

        fi.close();

        int max = -1;

        for (int i:arr)
            if(i > max)
                max = i;


        for (int i = 0; i < arr.length; i++)
        if(arr[i] == max)
            System.out.print(i + " ");
    }
}
