package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes e) throws IllegalArgumentException {
        if (false == e instanceof ImageTypes)
            throw new IllegalArgumentException("Неизвестный тип картинки");

        ImageReader res = new ImageReader() {
        };

        switch (e) {
            case BMP:
                res = new BmpReader();
                break;
            case PNG:
                res = new PngReader();
                break;
            case JPG:
                res = new JpgReader();
                break;
        }
        return res;
    }
}
