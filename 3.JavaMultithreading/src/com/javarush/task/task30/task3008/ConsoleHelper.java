package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        boolean hasMistake = true;
        String string = "";

        while (hasMistake) {
            try {
                string = bufferedReader.readLine();
                if (null != string)
                    hasMistake = false;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return string;
    }

    public static int readInt() {
        int result = 0;
        boolean hasMistake = true;

        while (hasMistake) {
            try {
                result = Integer.parseInt(readString().trim());
                hasMistake = false;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return result;
    }
}
