package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();

        bufferedReader.close();

        FileReader fr = new FileReader(s1);
        FileWriter fw = new FileWriter(s2);

        for (int i = 0; fr.ready(); i++) {
            int ch = fr.read();

            if (i % 2 == 1)
                fw.append((char) ch);
        }

        fr.close();
        fw.close();
    }
}
