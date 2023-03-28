package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        boolean tested = false;
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = tested ? "D:\\1.txt" : reader.readLine();

        } catch (IOException ignore) {
            /* NOP */
        }
        String input = "";
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while ((input = fileReader.readLine()) != null)
                System.out.println(new StringBuffer(input).reverse());
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
