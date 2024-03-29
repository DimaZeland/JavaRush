package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (null != is) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            writer.write(line);

            while (null != (line = bufferedReader.readLine())) {
                writer.write(line);
            }
        }
        return writer;
    }
}
