package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        FileInputStream fi1 = new FileInputStream(str1);
        FileOutputStream fo1 = new FileOutputStream(str1);
        FileInputStream fi2 = new FileInputStream(str2);

        byte[] arr1 = new byte[fi1.available()];
        byte[] arr2 = new byte[fi2.available()];

        fi1.read(arr1,0, arr1.length);
        fi2.read(arr2,0, arr2.length);

        fo1.write(arr2,0,arr2.length);
        fo1.write(arr1,0,arr1.length);

        fi1.close();
        fi2.close();
        fo1.close();
    }
}
