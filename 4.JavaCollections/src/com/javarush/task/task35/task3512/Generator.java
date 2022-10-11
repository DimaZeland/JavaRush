package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> generatorTask;
    public Generator(Class<T> generatorTask) {
        this.generatorTask = generatorTask;
    }
    T newInstance() throws IllegalAccessException, InstantiationException{
        return generatorTask.newInstance();
    }
}
