package com.javarush.task.task18.task1821;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
       /* String fileName = args[0];
        FileReader fr = new FileReader(fileName);

        HashMap<Integer,Integer> symbols = new HashMap<>();

        while (fr.ready())
        {
            int symb = fr.read();
            int symbCount = 0;
            if(symbols.containsKey(symb))
                symbCount = symbols.get(symb) + 1;

            symbols.put(symb,symbCount);
        }
        fr.close();

        Set<Map.Entry<Integer,Integer>> en = symbols.entrySet();

        en.stream()
                        .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x-> System.out.println(((char)x.getKey().intValue()) + " " + x.getValue()));*/
        int[] aSCII = new int[128];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        }
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
        }
    }
}
