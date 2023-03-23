package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            int number = Integer.valueOf(args[1]);
            int textLength = args[2].length();
            int fileLength = (int) raf.length();
            byte[] bytes = new byte[textLength];
            raf.seek(number);
            raf.read(bytes, 0, textLength);
            String readText = new String(bytes);
            String word = (args[2].equals(readText)) ? "true" : "false";
            raf.seek(fileLength);
            raf.write(word.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
