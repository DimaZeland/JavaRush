package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {


        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String file = br.readLine();
                try (FileInputStream fi = new FileInputStream(file)) {
                    if (fi.available() < 1000) {
                        throw new DownloadException();
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
