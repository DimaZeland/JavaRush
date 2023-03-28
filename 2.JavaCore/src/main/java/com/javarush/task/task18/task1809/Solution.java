package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f1 = br.readLine();
        String f2 = br.readLine();

        FileInputStream fi = new FileInputStream(f1);
        FileOutputStream fo = new FileOutputStream(f2);

        int count = 0;
        byte[] arr = {};

        while (fi.available() > 0) {
            arr = new byte[fi.available()];
            count = fi.read(arr);
        }

        fi.close();

        Byte[] bytes = new Byte[arr.length];
        byte[] finalArr = arr;
        Arrays.setAll(bytes, n -> finalArr[n]);

        Collections.reverse(Arrays.asList(bytes));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = bytes[i];
        }


        fo.write(arr, 0, count);
        fo.close();
    }
}
