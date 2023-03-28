package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("name", "Ivanov");
        paramsMap.put("country", "Ukraine");
        paramsMap.put("city", "Kiev");
        paramsMap.put("age", null);
        System.out.println(getQuery(paramsMap));
    }

    public static String getQuery(Map<String, String> params) {
        // {name=Ivanov, country=Ukraine, city=Kiev, age=null}
        // name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'

        StringBuilder stringBuilder = new StringBuilder();
        String format = "%s = '%s'";
        String result;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                result = stringBuilder.toString().length() != 0 ? " and " : "";
                result += String.format(format, entry.getKey(), entry.getValue());
                stringBuilder.append(result);
            }
        }
        return stringBuilder.toString();
    }
}
