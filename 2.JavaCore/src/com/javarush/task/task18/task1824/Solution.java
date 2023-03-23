package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = "";

        while (true) {
            fname = br.readLine();
            try (FileInputStream fi = new FileInputStream(fname)) {

            } catch (FileNotFoundException e) {
                System.out.println(fname);
                break;
            }
        }
    }
}
