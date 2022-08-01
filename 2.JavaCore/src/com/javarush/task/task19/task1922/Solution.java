package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    private static boolean tested = false;
    static {
        if(tested)
        {
            words.add("А");
            words.add("Б");
            words.add("В");
        }
        else
        {
            words.add("файл");
            words.add("вид");
            words.add("В");
        }
    }

    public static void main(String[] args) {
        String file1 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();

        } catch (IOException ignore) {
            /* NOP */
        }

        try (BufferedReader in = new BufferedReader(new FileReader(file1))) {
            while (in.ready()) {
                String readedString = in.readLine();
                String[] splitedReadedString = readedString.split(" ");

                int wordCount = 0;
                for (String s : splitedReadedString) {
                    if (words.contains(s)) {
                        wordCount++;
                    }
                }

                if (wordCount == 2)
                    System.out.println(readedString);
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }


    /*public static void main(String[] args) throws IOException{


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = tested ? "D:\\1.txt" : bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = "";
        List<String> linesWithTwoWords = new ArrayList<>();

        while (null != (line = bufferedReader.readLine()))
        {
            int matchCount = 0;

            for (String word:words)
                if(line.contains(word))
                    ++matchCount;

            if(2 == matchCount)
            linesWithTwoWords.add(line);
        }

        bufferedReader.close();

        //linesWithTwoWords.forEach(System.out::println);

        for (String currentLine:linesWithTwoWords)
            System.out.println(currentLine);
    }*/
}
