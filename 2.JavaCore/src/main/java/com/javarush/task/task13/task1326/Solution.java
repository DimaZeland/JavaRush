package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        scanner = new Scanner(new FileInputStream(path));

        ArrayList<Integer> list = new ArrayList<>();

        while (scanner.hasNext())
            list.add(scanner.nextInt());

        list.stream().filter(x -> 0 == x % 2).sorted().forEach(System.out::println);
        scanner.close();
    }
}
