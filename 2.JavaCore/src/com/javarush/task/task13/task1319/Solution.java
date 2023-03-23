package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        File file = new File(line);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            stringBuilder.append(line).append("\n");

            if ("exit".equals(line)) {
                break;
            }
        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        scanner.close();

    }
}
