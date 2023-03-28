package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fo;

    public AmigoOutputStream(FileOutputStream f) throws FileNotFoundException {
        super(fileName);
        fo = f;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.clone();
    }

    @Override
    public void write(int b) throws IOException {
        fo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fo.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        fo.flush();
        fo.write("JavaRush © All rights reserved.".getBytes(StandardCharsets.UTF_8));
        fo.close();
    }

    @Override
    public void flush() throws IOException {
        fo.flush();
    }
}
