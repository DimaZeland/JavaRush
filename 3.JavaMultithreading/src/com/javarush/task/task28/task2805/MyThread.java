package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static volatile AtomicInteger priority = new AtomicInteger(0);

    private static /*synchronized*/ int getNextPriority() {
        int i = priority.incrementAndGet();

        if (i > 10) {
            i = i % 10;
            priority.set(i);
        }

        return i;
    }

    private static /*synchronized*/ int getNextPriority(ThreadGroup group) {
        int max = group.getMaxPriority();

        int i = getNextPriority();

        return i > max ? max : i;
    }


    public MyThread() {
        setPriority(getNextPriority());
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(getNextPriority());

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(getNextPriority(group));
    }

    public MyThread(String name) {
        super(name);
        setPriority(getNextPriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(getNextPriority(group));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(getNextPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(getNextPriority(group));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(getNextPriority(group));
    }

    /*public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals)
    {
        super(group, target, name, stackSize, inheritThreadLocals);
        Thread.currentThread().setPriority(getNextPriority(group));
    }*/
}
