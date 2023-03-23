package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String arg = args[0];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fn = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(fn));

        while (br.ready()) {
            String stroka = br.readLine();

            String[] list = stroka.split(" ");

            if (arg.equals(list[0])) {
                System.out.println(stroka);
                break;
            }
        }
        br.close();
    }
}
