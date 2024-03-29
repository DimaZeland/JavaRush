package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "w")) {
            int number = Integer.parseInt(args[1]);
            long length = raf.length();
            byte[] bytes = args[2].getBytes(StandardCharsets.UTF_8);

            if (number > length) {
                raf.seek(length);
            } else {
                raf.seek(number);
            }

            raf.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
