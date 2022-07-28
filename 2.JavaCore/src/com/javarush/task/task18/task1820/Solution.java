package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        FileReader fi1 = new FileReader(str1);
        FileWriter fo2 = new FileWriter(str2);

        String number = "";
        double d = .0;
        int dInt = 0;

        while (fi1.ready())
        {
            char ch = (char) fi1.read();
            if (' ' != ch)
                number += ch;

            if (' ' == ch || fi1.ready() == false)
            {
                d = Double.parseDouble(number);

                dInt = (int) Math.round(d);
                number = String.valueOf(dInt) + ' ';
                fo2.write(number);
                number = "";
            }
        }
        fi1.close();
        fo2.close();
    }
}
