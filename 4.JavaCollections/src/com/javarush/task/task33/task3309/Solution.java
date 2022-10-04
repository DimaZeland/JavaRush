package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/
/*import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;*/
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException
    {
        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(obj, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        String find = "<" + tagName+">";
        String replace = "<!--" + comment + "-->\n" + find;
        result = result.replaceAll(find,replace);

        return result;
    }

    public static void main(String[] args) {

    }
}
