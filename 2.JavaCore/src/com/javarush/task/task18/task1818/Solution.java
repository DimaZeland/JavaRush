package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        FileWriter fw1 = new FileWriter(str1);
        FileReader fr2 = new FileReader(str2);
        FileReader fr3 = new FileReader(str3);

        while(fr2.ready())
        {
            fw1.write(fr2.read());
        }

        while(fr3.ready())
        {
            fw1.append((char)fr3.read());
        }

        fw1.close();
        fr2.close();
        fr3.close();
    }
}
