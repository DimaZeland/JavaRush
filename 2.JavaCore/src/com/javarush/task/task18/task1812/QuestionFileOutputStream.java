package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream am;

    public QuestionFileOutputStream(AmigoOutputStream am) {
        this.am = am;
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if ("Д".equals(str))
            am.close();
    }

    @Override
    public void flush() throws IOException {
        am.flush();
    }

    @Override
    public void write(int b) throws IOException {
        am.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        am.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        am.write(b, off, len);
    }
}

