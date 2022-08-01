package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = /*"D:\\1.txt";//*/bufferedReader.readLine(); //
        String fileName2 = /*"D:\\2.txt";//*/bufferedReader.readLine(); // "D:\\2.txt";

        bufferedReader.close();

        FileReader fr1 = new FileReader(fileName1);
        FileReader fr2 = new FileReader(fileName2);

        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);

        List<String> oldFileLines = new ArrayList<>();
        List<String> newFileLines = new ArrayList<>();

        String bufString = "";

        while ((bufString = br1.readLine()) != null)
            oldFileLines.add(bufString);

        while ((bufString = br2.readLine()) != null)
            newFileLines.add(bufString);

        br1.close();
        br2.close();

        int oldFileLine = 0;
        int newFileLine = 0;

        while ((oldFileLine < oldFileLines.size()) && (newFileLine < newFileLines.size()))
        {

            if (oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine)))
            {
                lines.add(new LineItem(Type.SAME, oldFileLines.get(oldFileLine)));
                oldFileLine++;
                newFileLine++;
            } else if ((newFileLine + 1 < newFileLines.size()) && oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine + 1)))
            {
                lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
                newFileLine++;
            } else if ((oldFileLine + 1 < oldFileLines.size()) && oldFileLines.get(oldFileLine + 1).equals(newFileLines.get(newFileLine)))
            {
                lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
                oldFileLine++;
            }
        }

        while (oldFileLine < (oldFileLines.size()))
        {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
            oldFileLine++;
        }
        while (newFileLine < (newFileLines.size()))
        {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
            newFileLine++;
        }

        /*int size1 = oldFileLines.size();
        int size2 = newFileLines.size();

        String str1 = "";
        String str2 = "";
        String str1Next = "";
        String str2Next = "";

        for (int oldFileLine = 0, newFileLine = 0; true; )
        {
            if (oldFileLine < size1)
                str1 = oldFileLines.get(oldFileLine);

            if (newFileLine < size2)
                str2 = newFileLines.get(newFileLine);

            if (oldFileLine + 1 < size1)
                str1Next = oldFileLines.get(oldFileLine + 1);
            else
                str1Next = str1;

            if (newFileLine + 1 < size2)
                str2Next = newFileLines.get(newFileLine + 1);
            else
                str2Next = str2;


            if (oldFileLine >= size1 && newFileLine < size2)// file1 ended
            {
                lines.add(new LineItem(Type.ADDED, str2));
                ++newFileLine;
            } else if (newFileLine >= size2 && oldFileLine < size1)// file2 ended
            {
                lines.add(new LineItem(Type.REMOVED, str1));
                ++oldFileLine;
            } else if (str1.equals(str2))
            {
                lines.add(new LineItem(Type.SAME, str1));
                ++oldFileLine;
                ++newFileLine;
            } else if (str2.equals(str1Next))
            {
                lines.add(new LineItem(Type.REMOVED, str1));
                ++oldFileLine;
            } else if (str1.equals(str2Next))
            {
                lines.add(new LineItem(Type.ADDED, str2));
                ++newFileLine;
            } else // file1 and file2 ended
                break;
        }*/
    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
