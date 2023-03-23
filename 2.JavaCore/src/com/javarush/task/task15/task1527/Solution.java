package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String parametersTail = url.substring(url.indexOf('?') + 1, url.length());

        String[] array = (parametersTail.split("&"));
        List<String> parameters = Arrays.asList(array);

        for (String parameter :
                parameters) {
            int charIndex = parameter.indexOf('=');
            url = -1 == charIndex ? parameter : parameter.substring(0, charIndex);
            System.out.println(url);
        }
        for (String parameter :
                parameters) {
            if ("obj".equals(parameter.substring(0, 3))) {
                url = parameter.substring(4, parameter.length());
                try {
                    double objParameter = Double.parseDouble(url);
                    alert(objParameter);
                } catch (NumberFormatException e) {
                    alert(url);
                }
                break;
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
