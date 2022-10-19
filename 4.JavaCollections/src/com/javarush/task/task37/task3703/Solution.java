package com.javarush.task.task37.task3703;

import java.util.concurrent.ConcurrentSkipListMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return ConcurrentSkipListMap.class;
    }
    /*public static Class getExpectedClass() {
        Set<Class> classes = findAllClassesUsingReflectionsLibrary("java.util");
        for(Class<?> clazz:classes){
            if(ConcurrentNavigableMap.class.isAssignableFrom(clazz) && Serializable.class.isAssignableFrom(clazz)
                    && Cloneable.class.isAssignableFrom(clazz) && Map.class.isAssignableFrom(clazz)) {
                System.out.println(clazz.getSimpleName());
                return clazz;
            }

        }
        return null;
    }
    public static Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(AbstractMap.class)
                .stream()
                .collect(Collectors.toSet());
    }*/
}
