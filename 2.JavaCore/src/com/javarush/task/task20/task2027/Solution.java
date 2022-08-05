package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Кроссворд
*/

public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        System.out.println((char) crossword[0][0]);
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> result = new ArrayList<>();
        int hor = crossword[0].length;
        int ver = crossword.length;

        outer:
        for (String s : words) {
            //по горизонтали
            for (int i = 0; i < ver; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hor; j++)
                    sb.append((char) crossword[i][j]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(horLine.indexOf(s), i);
                    word.setEndPoint(horLine.indexOf(s) + s.length() - 1, i);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(hor - horReverse.indexOf(s) - 1, i);
                    word.setEndPoint(hor - horReverse.indexOf(s) - s.length(), i);

                    result.add(word);
                    continue outer;
                }
            }
            //по вертикали
            for (int i = 0; i < hor; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] aCrossword : crossword)
                    sb.append((char) aCrossword[i]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, horLine.indexOf(s));
                    word.setEndPoint(i, horLine.indexOf(s) + s.length() - 1);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, ver - horReverse.indexOf(s) - 1);
                    word.setEndPoint(i, ver - s.length() - horReverse.indexOf(s));

                    result.add(word);
                    continue outer;
                }
            }

            //по диагонали вправо
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp < hor) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp++;
                    }
                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j + horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j + horLine.indexOf(s) + s.length() - 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp - 1 - horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp - horReverse.indexOf(s) - s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }

            //по диагонали влево
            for (int i = 0; i < ver; i++) {
                for (int j = hor - 1; j >= 0; j--) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp >= 0) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp--;
                    }

                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j - horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j - horLine.indexOf(s) - s.length() + 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp + 1 + horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp + horReverse.indexOf(s) + s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }
        }

        System.out.println(result);

        return result;
    }

    /*public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        List<Word> result = new ArrayList<>();

        List<String> wordsAll = new ArrayList<>();

        for (String word : words)
            wordsAll.add(word);

        for (int i = 0; i < words.length; i++)
        {
            String reverseWord = new StringBuilder(words[i]).reverse().toString();
            wordsAll.add(reverseWord);
        }

        final int reverseIndex = wordsAll.size() / 2;

        for (int i = 0; i < wordsAll.size(); i++)
        {
            String word = wordsAll.get(i);

            for (int h = 0; h < crossword[0].length; h++)
                for (int v = 0; v < crossword.length; v++)
                {
                    char ch = (char) crossword[v][h];
                    if (ch == word.charAt(0)) // find first letter match
                    {
                        if (h + word.length() <= crossword[0].length) // the word is placed horizontally
                        {
                            boolean findEnd = true;

                            for (int h1 = h + 1, w1 = 1; w1 < word.length(); ++h1, ++w1) // until we have passed all the letters of the word
                                if (word.charAt(w1) != (char) crossword[v][h1]) // the letter in the word and the array do not match
                                {
                                    findEnd = false;
                                    break;
                                }

                            if (findEnd)
                            {
                                String nativeWord = i < reverseIndex ? word : new StringBuilder(word).reverse().toString();
                                Word hWord = new Word(nativeWord);
                                if (i < reverseIndex) // words in ascending order of letters
                                {
                                    hWord.setStartPoint(h, v);
                                    hWord.setEndPoint(h + word.length() - 1, v);
                                } else
                                {
                                    hWord.setStartPoint(h + word.length() - 1, v);
                                    hWord.setEndPoint(h, v);
                                }
                                result.add(hWord);
                            }
                        }

                        if (v + word.length() <= crossword.length) // the word is placed vertically
                        {
                            boolean findEnd = true;

                            for (int v1 = v + 1, w1 = 1; w1 < word.length(); ++v1, ++w1) // until we have passed all the letters of the word
                                if (word.charAt(w1) != (char) crossword[v1][h]) // the letter in the word and the array do not match
                                {
                                    findEnd = false;
                                    break;
                                }

                            if (findEnd)
                            {
                                String nativeWord = i < reverseIndex ? word : new StringBuilder(word).reverse().toString();
                                Word hWord = new Word(nativeWord);
                                if (i < reverseIndex) // words in ascending order of letters
                                {
                                    hWord.setStartPoint(h, v);
                                    hWord.setEndPoint(h, v + word.length() - 1);
                                } else
                                {
                                    hWord.setStartPoint(h, v + word.length() - 1);
                                    hWord.setEndPoint(h, v);
                                }
                                result.add(hWord);
                            }
                        }

                        if (h + word.length() <= crossword[0].length && v + word.length() <= crossword.length) // the word is placed diagonals
                        {
                            boolean findEnd = true;

                            for (int h1 = h + 1, v1 = v + 1, w1 = 1; w1 < word.length(); ++h1, ++v1, ++w1) // until we have passed all the letters of the word
                                if (word.charAt(w1) != (char) crossword[v1][h1]) // the letter in the word and the array do not match
                                {
                                    findEnd = false;
                                    break;
                                }

                            if (findEnd)
                            {
                                String nativeWord = i < reverseIndex ? word : new StringBuilder(word).reverse().toString();
                                Word hWord = new Word(nativeWord);

                                if (i < reverseIndex) // words in ascending order of letters
                                {
                                    hWord.setStartPoint(h, v);
                                    hWord.setEndPoint(h + word.length() - 1, v + +word.length() - 1);
                                } else
                                {
                                    hWord.setStartPoint(h + word.length() - 1, v + +word.length() - 1);
                                    hWord.setEndPoint(h, v);
                                }
                                result.add(hWord);
                            }
                        }
                    }
        }
        }
        Collections.swap(result,0,1);

        System.out.println(result);

        return result;
    }*/

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
