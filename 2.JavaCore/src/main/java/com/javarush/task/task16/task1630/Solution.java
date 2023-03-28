package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = br.readLine();
            secondFileName = br.readLine();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String name;
        //private List<String> list;
        private String fileInString;

        public void setFileName(String fullFileName) {
            name = fullFileName;
        }

        public String getFileContent() {
            return fileInString == null ? "" : fileInString;
            /*StringBuilder sb = new StringBuilder();

            for (String str:list)
            {
                sb.append(str + ' ');
            }
            return null == list ? "" : sb.toString().trim();*/
        }

        //public void join() throws InterruptedException{};

        public void start() {
            run();
        }

        @Override
        public void run() {
            List<String> list = new ArrayList<>();
            {
            }
            ;

            try {
                list = Files.readAllLines(Paths.get(name));
            } catch (IOException e) {
            }

            StringBuilder sb = new StringBuilder();

            for (String str : list) {
                sb.append(str + ' ');
            }
            fileInString = null == list ? "" : sb.toString().trim();
        }
    }
}
