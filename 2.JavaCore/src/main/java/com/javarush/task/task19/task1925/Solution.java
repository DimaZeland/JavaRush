package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    //static boolean tested = false;
    public static void main(String[] args) {
        String fileName1 = args[0];
        String fileName2 = args[1];
        String input;

        ArrayList<String> fileContent = new ArrayList<String>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while ((input = fileReader.readLine()) != null)
                fileContent.add(input);
        } catch (IOException ignore) {
            /* NOP */
        }

        StringBuffer sbLine = new StringBuffer();
        for (String line : fileContent) {
            String[] splitedLine = line.split(" ");
            for (String word : splitedLine) {
                if (word.length() > 6)

                    sbLine.append(word).append(" ");
            }
        }

        String resultLine = sbLine.toString().trim().replaceAll(" ", ",");
        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            fileWriter.write(resultLine);
        } catch (IOException ignore) {
            /* NOP */
        }


        /* String name1 = args[0];
        String name2 = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(name1));
             FileWriter writer = new FileWriter(name2,false))
        {
            String line = "";

            while (null != (line = reader.readLine()))
            {
                String[] words = line.trim().split(" ");

                for (String word : words)
                    if (word.length() > 6)
                        writer.append(word + ",");
            }
        } catch (IOException e)
        {

        }*/
    }
}
