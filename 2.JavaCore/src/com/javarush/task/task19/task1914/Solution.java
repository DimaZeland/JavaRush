package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldStream = new PrintStream(System.out);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        String parsing = byteArrayOutputStream.toString();

        String[] res = parsing.trim().split(" ");

        System.setOut(oldStream);

        int a = Integer.parseInt(res[0]);
        int b = Integer.parseInt(res[2]);
        String sign = res[1];
        int result = 0;

        switch (sign)
        {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
        }

        parsing = parsing.trim() + " " + String.valueOf(result);

        System.out.println(parsing);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

