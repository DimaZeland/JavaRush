package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ignore) {
        }

        StringBuilder readFileContent = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                readFileContent.append(fileReader.readLine());
            }
        } catch (IOException ignore) {
        }

        String fileContent = readFileContent.toString().replaceAll("[\\r\\n]+", "");

        String tag = args[0];
        String openedTag = "<" + tag;
        String closedTag = "</" + tag;
        int openedTagIndex = fileContent.indexOf(openedTag);
        int closedTagIndex = fileContent.indexOf(closedTag);
        int closedTagCount = 0;
        ArrayList<Integer> openedTagsIndexes = new ArrayList<>();
        ArrayList<Integer> closedTagsIndexes = new ArrayList<>();

        while (openedTagIndex != -1 || closedTagIndex != -1) {
            if (openedTagIndex != -1 && openedTagIndex < closedTagIndex) {
                openedTagsIndexes.add(openedTagIndex);
                openedTagIndex = fileContent.indexOf(openedTag, openedTagIndex + 1);
            } else if (closedTagCount != -1 && (closedTagIndex < openedTagIndex || openedTagIndex == -1)) {
                closedTagsIndexes.add(closedTagIndex + tag.length() + 3);
                closedTagCount++;
                closedTagIndex = fileContent.indexOf(closedTag, closedTagIndex + 1);
            }
        }

        Stack<String> stack = new Stack<>();
        for (int i = openedTagsIndexes.size() - 1; i >= 0; i--) {
            stack.push(fileContent.substring(openedTagsIndexes.get(i), getNextCloseTag(closedTagsIndexes, openedTagsIndexes.get(i))));
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    private static int getNextCloseTag(ArrayList<Integer> closedTagsIndexes, Integer openTagIndex) {
        Iterator<Integer> iterator = closedTagsIndexes.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > openTagIndex) {
                iterator.remove();
                return next;
            }
        }
        return 0;
    }


    /*
    private static boolean tested = true;

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = tested ? "D:\\1.txt" : bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileName1);

        StringBuilder stringBuilder = new StringBuilder();


        while (fileReader.ready())
        {
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();

        String htmlText = stringBuilder.toString();

        stringBuilder = null;

        final String tag = tested ? "span" : args[0];
        final String openTag = "<" + tag;
        final String closeTag = "</" + tag + ">";
        int nextOpenTagIndex = 0;
        int nextCloseTagIndex = 0;

        while (htmlText.length() > nextOpenTagIndex)
        {
            nextOpenTagIndex = htmlText.indexOf(openTag, nextOpenTagIndex);

            if(-1 == nextOpenTagIndex)
                break;

            nextCloseTagIndex = htmlText.indexOf(closeTag, nextOpenTagIndex);
            String subHtmlText = htmlText.substring(nextOpenTagIndex, nextCloseTagIndex);

            int check;// = getCounterOpenTag(openTag, subHtmlText);
            int shiftSubString;
            do
            {
                check = getCounterOpenTag(openTag, subHtmlText);

                int counterOpenTag = getCounterOpenTag(openTag, subHtmlText);

                shiftSubString = GetShiftSubString(counterOpenTag, nextOpenTagIndex, closeTag, htmlText);

                subHtmlText = htmlText.substring(nextOpenTagIndex, shiftSubString);

            }while (check != getCounterOpenTag(openTag, subHtmlText));

            System.out.println(subHtmlText);

            nextOpenTagIndex = shiftSubString;
        }
    }
    private static int getCounterOpenTag(String openTag, String subHtmlText)
    {
        Pattern p = Pattern.compile(openTag);
        Matcher m = p.matcher(subHtmlText);

        int counterOpenTag = 0;
        while (m.find()) // counting opening tags in a substring
            counterOpenTag++;

        return counterOpenTag;
    }

    private static int GetShiftSubString(int counterOpenTag, int nextOpenTagIndex, String closeTag, String htmlText)
    {
        int endIndex = 0;

        for (; counterOpenTag > 0; --counterOpenTag) // search for the start index of the last closing tag
        {
            String subHtmlText = htmlText.substring(nextOpenTagIndex,htmlText.length());
            endIndex = subHtmlText.indexOf(closeTag) + closeTag.length();

            if (counterOpenTag > 0)
                nextOpenTagIndex += endIndex;

        }
        return nextOpenTagIndex;
    }
     */
}
