package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String f1 = br.readLine();
        String f2 = br.readLine();

        br.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(f1));

        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) {
            char ch = (char) fileReader.read();
            sb.append(ch);
        }

        fileReader.close();

        String res = sb.toString().replaceAll("\\p{P}", "");
        sb = null;

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f2));

        bufferedWriter.write(res);

        bufferedWriter.close();
    }
}
