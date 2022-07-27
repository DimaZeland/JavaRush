package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые редкие байты
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        /*FileInputStream fi = new FileInputStream(fileName);

        int n = 0;
        int value = 0;

        Map<Byte, Integer> container = new HashMap<Byte, Integer>();
        while (fi.available() > 0)
        {
            n = fi.read();

            value = container.containsKey((byte) n) ? container.get((byte) n) : 0;
            container.put((byte) n, value + 1);
        }
        fi.close();

        // sort map by value
        container = container.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));


        Iterator iterator = container.entrySet().iterator();

        Map.Entry<Byte, Integer> firstEntry = (Map.Entry<Byte, Integer>) iterator.next();

        int minRepeat = firstEntry.getValue();

        iterator = container.entrySet().iterator();

        int nextRepeat;

        do
        {
            Map.Entry<Byte, Integer> entry = (Map.Entry<Byte, Integer>) iterator.next();

            nextRepeat = entry.getValue();

            if (nextRepeat == minRepeat)
                System.out.print(entry.getKey() + ' ');
            else
                break;
        } while (true);
    }*/
        int[] byteCountArray = new int[256];
        try (FileInputStream fileInputStream = new FileInputStream(fileName))
        {
            while (fileInputStream.available() > 0)
            {
                byteCountArray[fileInputStream.read()] += 1;
            }
        }
        int minCount = Integer.MAX_VALUE;
        for (int byteCount : byteCountArray)
        {
            if (byteCount > 0 && byteCount < minCount) minCount = byteCount;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < byteCountArray.length; i++)
        {
            if (byteCountArray[i] == minCount) resultList.add(i);
        }
        for (Integer resultItem : resultList) System.out.print(resultItem + " ");
    }
}
