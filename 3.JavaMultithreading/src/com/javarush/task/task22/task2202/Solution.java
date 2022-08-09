package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splitWithSpaces = string.split(" ");

        if (splitWithSpaces.length < 5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(splitWithSpaces[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();

        /* try
        {
            int index = 0;
            for (int i = 0; i < 5; i++)
            {
                index = string.indexOf(' ', index) + 1;
            }

            index = 0 == index ? string.length() : index;

            return string.substring(string.indexOf(' ')+1,index);
        }catch (Throwable e)
        {
            throw new TooShortStringException();
        }*/
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
