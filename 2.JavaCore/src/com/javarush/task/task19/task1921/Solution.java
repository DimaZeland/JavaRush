package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Boolean tested = false;

        String fileName = tested ? "D:\\1.txt" : args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = "";

        while (null != (line = bufferedReader.readLine())) {
            String[] lineValues = line.split(" ");

            int lineValuesLastIndex = lineValues.length - 1;

            int year = Integer.parseInt(lineValues[lineValuesLastIndex]);

            --lineValuesLastIndex;

            int month = Integer.parseInt(lineValues[lineValuesLastIndex]);

            --lineValuesLastIndex;

            int day = Integer.parseInt(lineValues[lineValuesLastIndex]);

            --lineValuesLastIndex;

            Calendar calendar = new GregorianCalendar(year, month - 1, day);
            Date birthDate = calendar.getTime();

            String name = "";

            for (int i = 0; i <= lineValuesLastIndex; i++) {
                name += lineValues[i] + " ";
            }

            PEOPLE.add(new Person(name.trim(), birthDate));
        }

        bufferedReader.close();
    }
}
