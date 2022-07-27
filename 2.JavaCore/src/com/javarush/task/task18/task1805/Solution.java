package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        Set<Integer> bytes = new TreeSet<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                bytes.add(fileInputStream.read());
            }
        }
        for (Integer aByte : bytes) {
            System.out.print(aByte + " ");
        }

        /*FileInputStream fi = new FileInputStream(fileName);

        int[] array = new int[255];

        while (fi.available() > 0)
        {
            array[fi.read()] = 1;
        }

        fi.close();

        for (int i = 0; i < array.length; i++)
        {
            if(1 == array[i])
                System.out.print((byte)i + ' ');
        }*/
    }
}
