package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();

        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();

            prop.setProperty(name, value);
        }

        prop.store(outputStream, null);
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);

        for (Map.Entry<Object, Object> pair : prop.entrySet()) {
            runtimeStorage.put(pair.getKey().toString(), pair.getValue().toString());
        }
    }

    /*public static void load(InputStream inputStream) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine()
                    .replaceAll("[=:]", " = ") // language:Russian -> language = Russian
                    .replaceAll("  ", " ") // message  =  text -> message = text
                    .trim();

            if (Character.valueOf(line.charAt(0)).equals('!') || Character.valueOf(line.charAt(0)).equals('#'))
                continue; // comments

            String[] words = line.split(" ");

            int assignmentCharacterIndex = -1;
            //find assignment character
            for (int i = 0; i < words.length; i++)
            {
                if (words[i].equals(":") || words[i].equals("="))
                {
                    assignmentCharacterIndex = i;
                    break;
                }
            }

            String parameterName = "";

            if (-1 != assignmentCharacterIndex)
                for (int i = 0; i < assignmentCharacterIndex; i++)
                {
                    parameterName += words[i] + " ";
                }

            parameterName = parameterName.replaceAll("/\\/", "").trim(); // key\ with\ spaces -> key with spaces

            String sign = words[assignmentCharacterIndex]; // =

            String parameterValue = "";

            for (int i = assignmentCharacterIndex + 1; i < words.length; i++)
            {
                parameterValue += words[i] + " ";
            }

            parameterValue = parameterValue.trim();

            while (Character.valueOf(parameterValue.charAt(parameterValue.length() - 1)).equals('\\'))
                parameterValue += bufferedReader.readLine().trim();

            parameterValue = parameterValue.replaceAll("/\\/", ""); // value\ -> value

            runtimeStorage.put(parameterName, parameterValue);
        }
        bufferedReader.close();
    }*/

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
