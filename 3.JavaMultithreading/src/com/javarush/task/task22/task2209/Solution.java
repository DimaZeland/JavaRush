package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        boolean isTest = false;
        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(isTest ? "D:\\1.txt" : bufferedReader.readLine()));
        bufferedReader.close();

        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        String[] arr = new String[words.size()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = words.get(i);


        StringBuilder result = getLine(arr);
        System.out.println(result.toString());
    }

    /*public static StringBuilder getLine(String... words)
    {
        if(0 == words.length)
        return new StringBuilder();

        List<String> list = new ArrayList<>();

        for (String word : words)
            list.add(word);

        StringBuilder stringBuilder = new StringBuilder(list.get(0));

        char last = list.get(0).charAt(list.get(0).length() - 1);

        list.remove(list.get(0));

        for (int i = 0; list.size() > 0; ++i)
        {
            String word = list.get(i);

            if (last == Character.toLowerCase(word.charAt(0)))
            {
                last = word.charAt(word.length() - 1);
                stringBuilder.append(" " + word);
                list.remove(word);
                i = -1;
            }
        }
        return stringBuilder;
    }*/

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    private static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    private static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }
}
