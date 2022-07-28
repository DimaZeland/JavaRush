package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String name = args[0];

        FileReader fr = new FileReader(name);

        int countC = 0;
        int whiteSpaceCount = 0;

        while (fr.ready())
        {
           int symb = fr.read();
            ++countC;

            if( symb == (int) ' ')
                ++whiteSpaceCount;
        }
        fr.close();

        if(0 != countC)
        {
            double koef =  (double) whiteSpaceCount / countC * 100;
        /*BigDecimal result = new BigDecimal(koef);
        result = result.setScale(2, RoundingMode.DOWN);*/

            System.out.printf("%.2f", koef);
        }
    }
}
