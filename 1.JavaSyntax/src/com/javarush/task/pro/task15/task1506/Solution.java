package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution
{
    public static void main(String[] args)
    {
        try(Scanner scanner = new Scanner(System.in))
        {
            List<String> fileText = Files.readAllLines(Paths.get(scanner.nextLine()));

            fileText.forEach(string ->{
                char[] chars = string.toCharArray();
                
                for(char ch: chars)
                    if(ch != ' ' && ch != '.' && ch != ',')
                        System.out.print(ch);
            });
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

