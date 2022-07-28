package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fName = "";
        while (!"exit".equals(fName = br.readLine()))
        {
            ReadThread r = new ReadThread(fName);
        }
    }

    public static class ReadThread extends Thread
    {
        private String str;

        public ReadThread(String fileName)
        {
            str = fileName;
            this.start();
        }

        @Override
        public void run()
        {
            byte[] arr = new byte[256];
            try (FileInputStream fi = new FileInputStream(str))
            {
                while (fi.available() > 0)
                {
                    arr[fi.read()] += 1;
                }
                int max = -1;
                byte maxByte = 0;
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] > max)
                    {
                        max = arr[i];
                        maxByte = (byte)i;
                    }
                }

                resultMap.put(str, (int)maxByte);
            } catch (FileNotFoundException e)
            {

            } catch (IOException e)
            {

            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
