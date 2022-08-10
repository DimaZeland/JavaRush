package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String file1 = args[0];
        String file2 = args[1];

        InputStream inputStream = new FileInputStream(file1);
        byte[] bytes = new byte[inputStream.available()];

        //bytes = inputStream.readAllBytes();

        int i = 0;
        while (inputStream.available() > 0)
            bytes[i++] = (byte) inputStream.read();

        inputStream.close();

        String result = new String(bytes, "Windows-1251");
        bytes = result.getBytes(StandardCharsets.UTF_8);

        FileOutputStream outputStream = new FileOutputStream(file2);
        outputStream.write(bytes);
        outputStream.close();

        /*
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {

            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
            }
        }

         */
    }
}
