package com.javarush.task.task36.task3602;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class clazz : Collections.class.getDeclaredClasses()) {
            if (clazz.getSimpleName().equals("EmptyList")) {
                return clazz;
            }
        }
        return null;
    }
    /*public static Class getExpectedClass() throws NoSuchMethodException, InstantiationException, IllegalAccessException
    {
        Class clazz = List.class;

        Class<?>[] arrayClasses = clazz.getDeclaredClasses();

        for (Class<?> clazz1 : arrayClasses)
        {
            try
            {
                boolean implementsListI = List.class.isAssignableFrom(clazz1); //мплементирует ли этот класс или его родитель (getSuperclass) интерфейс List (getInterfaces)
                boolean isPrivateClass = Modifier.isPrivate(clazz1.getModifiers()); // Является ли этот класс приватным
                boolean isStaticClass = Modifier.isStatic(clazz1.getModifiers()); // Является ли этот класс статическим

                if (implementsListI && isPrivateClass && isStaticClass)
                {
                    Method get = clazz1.getDeclaredMethod("get", int.class); // Получаем метод
                    get.setAccessible(true); //  устанавливаем ему доступность
                    Constructor constructor = clazz1.getDeclaredConstructor(); // Получаем конструктор
                    constructor.setAccessible(true); // устанавливаем ему доступность
                    Object object = constructor.newInstance(); // получаем объект класса
                    get.invoke(object, 0); // вызываем метод get() в объекта класса
                }
            } catch (InvocationTargetException e)
            {
                if (e.getCause().toString().contains("IndexOutOfBoundsException"))
                {
                    //Если отловили InvocationTargetException и
                    //в getCause() содержится "IndexOutOfBoundsException" – это наш класс, его и возвращаем
                    return clazz;
                }
            }
        }
        return null;
    }*/
}
