package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); ) {
                if (i >= words.size()) {
                    break;
                }
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
                    Pair pair = new Pair();
                    pair.first = words.get(j);
                    pair.second = words.get(i);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    j = 0;
                } else
                    j++;
            }
        }
    }

    /*public static void main(String[] args) throws IOException
    {
        boolean isTesting = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = isTesting ? "D:\\1.txt" : bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = "";
        List<String> words = new ArrayList<>();
        while (null != (line = bufferedReader.readLine()))
        {
            String[] wordsInLine = line.split(" ");

            for(String word: wordsInLine)
            words.add(word);
        }
        bufferedReader.close();


        for(int i = 0; i < words.size(); ++i )
        {
            String word = words.get(i);
            StringBuilder stringBuilder = new StringBuilder(word);
            String wordReverse = stringBuilder.reverse().toString();

            if(words.contains(wordReverse))
            {
                Pair pair = new Pair();
                pair.first = word;
                pair.second = wordReverse;
                result.add(pair);

                words.remove(word);
                words.remove(wordReverse);
            }
        }
    }*/

    public static class Pair {
        String first;
        String second;

        public Pair()
        {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
