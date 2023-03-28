package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        //digits 48-57
        // lowcase = 97-122
        // uppercase = 65-90

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int index1 = (int) (48 + Math.random() * 9);
            char ch1 = (char) index1;
            int index2 = (int) (97 + Math.random() * 25);
            char ch2 = (char) index2;
            int index3 = (int) (65 + Math.random() * 25);
            char ch3 = (char) index3;
            stringBuilder.append(ch1).append(ch2).append(ch3);
        }
        byte[] bytes = stringBuilder.deleteCharAt(8).toString().getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}
