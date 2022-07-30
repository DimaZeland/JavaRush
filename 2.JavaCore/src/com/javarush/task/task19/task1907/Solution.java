package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        br.close();

        FileReader fr = new FileReader(s);
        StringBuilder sb = new StringBuilder();

        while (fr.ready())
        {
            char ch = (char) fr.read();
            sb.append(ch);
        }

        fr.close();

        String replaceString = sb.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

        sb = null;

        int count = 0;

        for (String st : replaceString.split(" "))
            if (st.equals("world"))
                ++count;

        System.out.println(count);
    }
}
