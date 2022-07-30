package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String f1 = br.readLine();
        String f2 = br.readLine();

        br.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(f1));

        StringBuilder sb = new StringBuilder();

        while (fileReader.ready())
        {
            char ch = (char) fileReader.read();
            sb.append(ch);
        }

        fileReader.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(f2));

        for (String s : sb.toString().split(" "))
        {
            int i = 0;
            try
            {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {}
            bw.append(String.valueOf(i) + " ");
        }
        sb = null;
        bw.close();
    }
}
